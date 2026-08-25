package edu.uees.tutorias.repository;

import edu.uees.tutorias.domain.Reserva;

public interface RepositorioReservas {

    void guardar(Reserva reserva);

    Reserva buscar(int id);

    void actualizar(Reserva reserva);
}