package org.example.mvc.repository;

import org.example.mvc.model.Registro;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MapRegistroRepository implements RegistroRepository {
    private final Map<Integer, Registro> registros = new LinkedHashMap<>();

    @Override
    public void save(Registro registro) {
        registros.put(registro.getId(), registro);
    }

    @Override
    public List<Registro> findAll() {
        return new ArrayList<>(registros.values());
    }

    @Override
    public Optional<Registro> findById(int id) {
        return Optional.ofNullable(registros.get(id));
    }
}
