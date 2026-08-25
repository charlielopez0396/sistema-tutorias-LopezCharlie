package edu.uees.tutorias.domain;

import java.time.LocalDate;

public class Reserva {

    private int id;
    private EstadoReserva estado;
    private LocalDate fechaReserva;

    public Reserva(int id, LocalDate fechaReserva) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.estado = EstadoReserva.PENDIENTE;
    }

    public void confirmar() {
        estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        estado = EstadoReserva.CANCELADA;
    }

    public void reprogramar() {
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
}