from .usuario import Usuario


class Estudiante(Usuario):
    def __init__(self, id_usuario: int, nombre: str, correo: str, carrera: str):
        super().__init__(id_usuario, nombre, correo)
        self._carrera = carrera

    def solicitar_tutoria(self):
        pass

    def cancelar_reserva(self):
        pass