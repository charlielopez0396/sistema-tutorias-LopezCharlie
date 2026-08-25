package edu.uees.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

import edu.uees.tutorias.domain.Asignatura;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioTutoria;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notification.Notificador;
import edu.uees.tutorias.notification.NotificadorEmail;
import edu.uees.tutorias.repository.RepositorioReservas;
import edu.uees.tutorias.repository.RepositorioReservasMemoria;
import edu.uees.tutorias.service.ServicioReservas;

public class Main {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante(
            1,
            "Carlos",
            "carlos@correo.com",
            "Sistemas"
        );

        Asignatura asignatura = new Asignatura(
            1,
            "Diseño de Software",
            "Diseño orientado a objetos"
        );

        HorarioTutoria horario = new HorarioTutoria(
            1,
            LocalDate.now(),
            LocalTime.of(10, 0),
            LocalTime.of(11, 0)
        );

        RepositorioReservas repositorio =
            new RepositorioReservasMemoria();

        Notificador notificador =
            new NotificadorEmail();

        ServicioReservas servicio =
            new ServicioReservas(repositorio, notificador);

        Reserva reserva =
            servicio.reservar(estudiante, horario, asignatura);

        System.out.println(
            "Reserva creada: " +
            (repositorio.buscar(reserva.getId()) != null)
        );

        System.out.println(
            "Horario disponible: " +
            horario.estaDisponible()
        );

        System.out.println(
            "Estado reserva: " +
            reserva.getEstado()
        );

        System.out.println(
            "Intentando reservar el mismo horario otra vez..."
        );

        try {
            servicio.reservar(estudiante, horario, asignatura);
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Reserva rechazada correctamente: " +
                e.getMessage()
            );
        }
    }
}