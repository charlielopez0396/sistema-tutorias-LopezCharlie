from .repositorio_reservas import RepositorioReservas
from ..domain.reserva import Reserva


class RepositorioReservasMemoria(RepositorioReservas):

    def __init__(self):
        self._reservas = {}

    def guardar(self, reserva: Reserva) -> None:
        self._reservas[reserva._id] = reserva

    def buscar(self, id_reserva: int) -> Reserva | None:
        return self._reservas.get(id_reserva)

    def actualizar(self, reserva: Reserva) -> None:
        if reserva._id not in self._reservas:
            raise ValueError("La reserva no existe.")

        self._reservas[reserva._id] = reserva