package edu.uees.tutorias.domain;

public class Docente extends Usuario {

    private String departamento;

    public Docente(
            int id,
            String nombre,
            String correo,
            String departamento) {

        super(id, nombre, correo);
        this.departamento = departamento;
    }

    public void publicarHorario() {
        // La gestión del horario se implementará con HorarioTutoria.
    }

    public void consultarHorarios() {
        // La consulta se coordinará con los horarios asociados al docente.
    }
}