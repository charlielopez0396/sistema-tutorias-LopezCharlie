from datetime import date

from ..domain.estudiante import Estudiante
from ..domain.horario_tutoria import HorarioTutoria
from ..domain.asignatura import Asignatura
from ..domain.reserva import Reserva
from ..notification.notificador import Notificador
from ..repository.repositorio_reservas import RepositorioReservas


class ServicioReservas:
    def __init__(
        self,
        repositorio: RepositorioReservas,
        notificador: Notificador
    ):
        self._repositorio = repositorio
        self._notificador = notificador
        self._siguiente_id = 1

    def reservar(
        self,
        estudiante: Estudiante,
        horario: HorarioTutoria,
        asignatura: Asignatura
    ) -> Reserva:

        if not horario.esta_disponible():
            raise ValueError("El horario seleccionado no está disponible.")

        reserva = Reserva(
            self._siguiente_id,
            date.today()
        )

        self._siguiente_id += 1

        horario.reservar()
        self._repositorio.guardar(reserva)

        self._notificador.enviar(
            estudiante._correo,
            "Su reserva de tutoría fue registrada correctamente."
        )

        return reserva

    def cancelar(
        self,
        reserva: Reserva,
        horario: HorarioTutoria
    ) -> None:

        reserva.cancelar()
        horario.liberar()
        self._repositorio.actualizar(reserva)

    def reprogramar(
        self,
        reserva: Reserva,
        nuevo_horario: HorarioTutoria
    ) -> None:

        if not nuevo_horario.esta_disponible():
            raise ValueError("El nuevo horario no está disponible.")

        reserva.reprogramar()
        nuevo_horario.reservar()
        self._repositorio.actualizar(reserva)