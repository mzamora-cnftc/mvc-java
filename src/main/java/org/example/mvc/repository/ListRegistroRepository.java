package org.example.mvc.repository;

import org.example.mvc.model.Registro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListRegistroRepository implements RegistroRepository {
    private final List<Registro> registros = new ArrayList<>();

    @Override
    public void save(Registro registro) {
        registros.add(registro);
    }

    @Override
    public List<Registro> findAll() {
        return new ArrayList<>(registros);
    }

    @Override
    public Optional<Registro> findById(int id) {
        for (Registro registro : registros) {
            if (registro.getId() == id) {
                return Optional.of(registro);
            }
        }
        return Optional.empty();
    }
}
