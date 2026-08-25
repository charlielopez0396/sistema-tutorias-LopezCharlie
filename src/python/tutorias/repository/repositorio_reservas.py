from abc import ABC, abstractmethod

from ..domain.reserva import Reserva


class RepositorioReservas(ABC):

    @abstractmethod
    def guardar(self, reserva: Reserva) -> None:
        pass

    @abstractmethod
    def buscar(self, id_reserva: int) -> Reserva | None:
        pass

    @abstractmethod
    def actualizar(self, reserva: Reserva) -> None:
        pass