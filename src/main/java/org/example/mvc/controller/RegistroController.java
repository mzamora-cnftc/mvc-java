package org.example.mvc.controller;

import org.example.mvc.model.Registro;
import org.example.mvc.service.RegistroService;
import org.example.mvc.view.ConsoleView;

import java.util.List;
import java.util.Optional;

public class RegistroController {
    private final ConsoleView view;
    private final RegistroService service;

    public RegistroController(ConsoleView view, RegistroService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        int option;
        try {
            do {
                option = mostrarMenu();
                procesarOpcion(option);
            } while (option != 0);
        } finally {
            view.close();
        }
    }

    private int mostrarMenu() {
        view.printLine("\n=== MENÚ MVC ===");
        view.printLine("1. Registrar dato");
        view.printLine("2. Listar (repositorio List)");
        view.printLine("3. Listar (repositorio Map)");
        view.printLine("4. Buscar por ID (Map)");
        view.printLine("5. Mostrar estadísticas");
        view.printLine("0. Salir");
        return view.readInt("Seleccione una opción:");
    }

    private void procesarOpcion(int option) {
        switch (option) {
            case 1:
                registrar();
                break;
            case 2:
                listar(service.listarDesdeList(), "LIST");
                break;
            case 3:
                listar(service.listarDesdeMap(), "MAP");
                break;
            case 4:
                buscarPorId();
                break;
            case 5:
                mostrarEstadisticas();
                break;
            case 0:
                view.printLine("Hasta luego.");
                break;
            default:
                view.printLine("Opción no válida.");
        }
    }

    private void registrar() {
        int id = view.readInt("ID:");
        String nombre = view.readString("Nombre:");
        double nota = view.readDouble("Nota:");
        boolean activo = view.readBoolean("¿Activo?");
        Registro registro = new Registro(id, nombre, nota, activo);
        service.guardar(registro);
        view.printLine(String.format("Registro guardado -> id=%d, nombre=%s, nota=%.2f, activo=%s",
                id, nombre, nota, activo));
    }

    private void listar(List<Registro> registros, String fuente) {
        view.printLine(String.format("Total registros en %s: %d", fuente, registros.size()));
        if (registros.isEmpty()) {
            view.printLine("No hay datos.");
            return;
        }
        for (Registro registro : registros) {
            view.printLine(String.format("id=%d | nombre=%s | nota=%.2f | activo=%s",
                    registro.getId(), registro.getNombre(), registro.getNota(), registro.isActivo()));
        }
    }

    private void buscarPorId() {
        int id = view.readInt("ID a buscar:");
        Optional<Registro> result = service.buscarPorIdEnMap(id);
        if (result.isPresent()) {
            Registro registro = result.get();
            view.printLine(String.format("Encontrado -> id=%d, nombre=%s, nota=%.2f, activo=%s",
                    registro.getId(), registro.getNombre(), registro.getNota(), registro.isActivo()));
            return;
        }
        view.printLine("No se encontró el registro.");
    }

    private void mostrarEstadisticas() {
        double promedio = service.promedioNotas();
        int activos = service.cantidadActivos();
        view.printLine(String.format("Promedio de notas: %.2f", promedio));
        view.printLine(String.format("Cantidad de activos: %d", activos));
    }
}
