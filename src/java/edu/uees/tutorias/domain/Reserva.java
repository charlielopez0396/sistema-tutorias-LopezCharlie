package edu.uees.tutorias.domain;

import java.time.LocalDate;

public class Reserva {

    private int id;
    private EstadoReserva estado;
    private LocalDate fechaReserva;
    private Estudiante estudiante;
    private HorarioTutoria horario;
    private Asignatura asignatura;

    public Reserva(
            int id,
            LocalDate fechaReserva,
            Estudiante estudiante,
            HorarioTutoria horario,
            Asignatura asignatura) {

        this.id = id;
        this.fechaReserva = fechaReserva;
        this.estudiante = estudiante;
        this.horario = horario;
        this.asignatura = asignatura;
        this.estado = EstadoReserva.PENDIENTE;
    }

    public void confirmar() {
        estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        estado = EstadoReserva.CANCELADA;
    }

    public void reprogramar(HorarioTutoria nuevoHorario) {
        this.horario = nuevoHorario;
        estado = EstadoReserva.PENDIENTE;
    }

    public void marcarRealizada() {
        estado = EstadoReserva.REALIZADA;
    }

    public int getId() {
        return id;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public HorarioTutoria getHorario() {
        return horario;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
}