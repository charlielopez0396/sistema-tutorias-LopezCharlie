from datetime import date

from .estado_reserva import EstadoReserva


class Reserva:

    def __init__(
        self,
        id: int,
        fecha_reserva: date,
        estudiante=None,
        horario=None,
        asignatura=None
    ):
        self._id = id
        self._estado = EstadoReserva.PENDIENTE
        self._fecha_reserva = fecha_reserva
        self._estudiante = estudiante
        self._horario = horario
        self._asignatura = asignatura

    def confirmar(self) -> None:
        self._estado = EstadoReserva.CONFIRMADA

    def cancelar(self) -> None:
        self._estado = EstadoReserva.CANCELADA

    def reprogramar(self, nuevo_horario=None) -> None:
        if nuevo_horario is not None:
            self._horario = nuevo_horario

        self._estado = EstadoReserva.PENDIENTE

    def marcar_realizada(self) -> None:
        self._estado = EstadoReserva.REALIZADA