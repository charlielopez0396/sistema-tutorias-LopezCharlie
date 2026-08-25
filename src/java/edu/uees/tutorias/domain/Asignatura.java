package edu.uees.tutorias.domain;

public class Asignatura {

    private int id;
    private String nombre;
    private String descripcion;

    public Asignatura(
            int id,
            String nombre,
            String descripcion) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String consultarInformacion() {
        return nombre + ": " + descripcion;
    }
}