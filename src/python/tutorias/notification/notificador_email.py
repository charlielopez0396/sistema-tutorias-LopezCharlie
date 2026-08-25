from .notificador import Notificador


class NotificadorEmail(Notificador):

    def enviar(self, destinatario: str, mensaje: str) -> None:
        print(f"Correo enviado a {destinatario}: {mensaje}")