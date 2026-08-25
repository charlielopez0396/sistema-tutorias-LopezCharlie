from .usuario import Usuario


class Docente(Usuario):
    def __init__(self, id_usuario: int, nombre: str, correo: str, departamento: str):
        super().__init__(id_usuario, nombre, correo)
        self._departamento = departamento

    def publicar_horario(self):
        pass

    def consultar_horarios(self):
        pass