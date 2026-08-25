from datetime import date, time


class HorarioTutoria:
    def __init__(
        self,
        id_horario: int,
        fecha: date,
        hora_inicio: time,
        hora_fin: time
    ):
        self._id = id_horario
        self._fecha = fecha
        self._hora_inicio = hora_inicio
        self._hora_fin = hora_fin
        self._disponible = True

    def reservar(self) -> None:
        self._disponible = False

    def liberar(self) -> None:
        self._disponible = True

    def esta_disponible(self) -> bool:
        return self._disponible