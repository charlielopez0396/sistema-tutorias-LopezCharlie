from datetime import date

from .estado_reserva import EstadoReserva


class Reserva:
    def __init__(self, id_reserva: int, fecha_reserva: date):
        self._id = id_reserva
        self._estado = EstadoReserva.PENDIENTE
        self._fecha_reserva = fecha_reserva

    def confirmar(self) -> None:
        self._estado = EstadoReserva.CONFIRMADA

    def cancelar(self) -> None:
        self._estado = EstadoReserva.CANCELADA

    def reprogramar(self) -> None:
        self._estado = EstadoReserva.PENDIENTE

    def marcar_realizada(self) -> None:
        self._estado = EstadoReserva.REALIZADA