package edu.uees.tutorias.domain;

public class Estudiante extends Usuario {

    private String carrera;

    public Estudiante(
            int id,
            String nombre,
            String correo,
            String carrera) {

        super(id, nombre, correo);
        this.carrera = carrera;
    }

    public void solicitarTutoria() {
        // La lógica se coordinará posteriormente desde ServicioReservas.
    }

    public void cancelarReserva() {
        // La lógica se coordinará posteriormente desde ServicioReservas.
    }
}