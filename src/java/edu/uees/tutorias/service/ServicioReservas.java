package edu.uees.tutorias.service;

import java.time.LocalDate;

import edu.uees.tutorias.domain.Asignatura;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioTutoria;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notification.Notificador;
import edu.uees.tutorias.repository.RepositorioReservas;

public class ServicioReservas {

    private final RepositorioReservas repositorio;
    private final Notificador notificador;
    private int siguienteId = 1;

    public ServicioReservas(
            RepositorioReservas repositorio,
            Notificador notificador) {

        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public Reserva reservar(
            Estudiante estudiante,
            HorarioTutoria horario,
            Asignatura asignatura) {

        if (!horario.estaDisponible()) {
            throw new IllegalArgumentException(
                "El horario seleccionado no está disponible."
            );
        }

        Reserva reserva = new Reserva(
            siguienteId,
            LocalDate.now()
        );

        siguienteId++;

        horario.reservar();
        repositorio.guardar(reserva);

        notificador.enviar(
            estudiante.getCorreo(),
            "Su reserva de tutoría fue registrada correctamente."
        );

        return reserva;
    }

    public void cancelar(
            Reserva reserva,
            HorarioTutoria horario) {

        reserva.cancelar();
        horario.liberar();
        repositorio.actualizar(reserva);
    }

    public void reprogramar(
            Reserva reserva,
            HorarioTutoria nuevoHorario) {

        if (!nuevoHorario.estaDisponible()) {
            throw new IllegalArgumentException(
                "El nuevo horario no está disponible."
            );
        }

        reserva.reprogramar();
        nuevoHorario.reservar();
        repositorio.actualizar(reserva);
    }
}