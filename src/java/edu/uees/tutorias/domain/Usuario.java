package edu.uees.tutorias.domain;

public abstract class Usuario {

    protected int id;
    protected String nombre;
    protected String correo;

    public Usuario(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String obtenerPerfil() {
        return nombre + " - " + correo;
    }

    public String getCorreo() {
        return correo;
    }
}