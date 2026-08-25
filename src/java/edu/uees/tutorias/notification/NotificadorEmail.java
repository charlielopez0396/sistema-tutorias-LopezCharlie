package edu.uees.tutorias.notification;

public class NotificadorEmail implements Notificador {

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println(
            "Correo enviado a " + destinatario + ": " + mensaje
        );
    }
}