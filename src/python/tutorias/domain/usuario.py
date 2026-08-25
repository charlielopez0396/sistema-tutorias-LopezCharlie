from abc import ABC


class Usuario(ABC):
    def __init__(self, id_usuario: int, nombre: str, correo: str):
        self._id = id_usuario
        self._nombre = nombre
        self._correo = correo

    def obtener_perfil(self) -> str:
        return f"{self._nombre} - {self._correo}"