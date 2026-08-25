class Asignatura:
    def __init__(self, id_asignatura: int, nombre: str, descripcion: str):
        self._id = id_asignatura
        self._nombre = nombre
        self._descripcion = descripcion

    def consultar_informacion(self) -> str:
        return f"{self._nombre}: {self._descripcion}"