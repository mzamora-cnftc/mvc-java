package org.example.mvc.repository;

import org.example.mvc.model.Registro;

import java.util.List;
import java.util.Optional;

public interface RegistroRepository {
    void save(Registro registro);

    List<Registro> findAll();

    Optional<Registro> findById(int id);
}
