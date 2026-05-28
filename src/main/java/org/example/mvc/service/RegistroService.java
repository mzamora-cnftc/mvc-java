package org.example.mvc.service;

import org.example.mvc.model.Registro;
import org.example.mvc.repository.RegistroRepository;

import java.util.List;
import java.util.Optional;

public class RegistroService {
    private final RegistroRepository listRepository;
    private final RegistroRepository mapRepository;

    public RegistroService(RegistroRepository listRepository, RegistroRepository mapRepository) {
        this.listRepository = listRepository;
        this.mapRepository = mapRepository;
    }

    public void guardar(Registro registro) {
        listRepository.save(registro);
        mapRepository.save(registro);
    }

    public List<Registro> listarDesdeList() {
        return listRepository.findAll();
    }

    public List<Registro> listarDesdeMap() {
        return mapRepository.findAll();
    }

    public Optional<Registro> buscarPorIdEnMap(int id) {
        return mapRepository.findById(id);
    }

    public double promedioNotas() {
        List<Registro> registros = listRepository.findAll();
        if (registros.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Registro registro : registros) {
            suma += registro.getNota();
        }
        return suma / registros.size();
    }

    public int cantidadActivos() {
        int total = 0;
        for (Registro registro : listRepository.findAll()) {
            if (registro.isActivo()) {
                total++;
            }
        }
        return total;
    }
}
