package org.example.mvc;

import org.example.mvc.controller.RegistroController;
import org.example.mvc.repository.ListRegistroRepository;
import org.example.mvc.repository.MapRegistroRepository;
import org.example.mvc.service.RegistroService;
import org.example.mvc.view.ConsoleView;

public class App {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        RegistroService service = new RegistroService(
                new ListRegistroRepository(),
                new MapRegistroRepository()
        );
        RegistroController controller = new RegistroController(view, service);
        controller.run();
    }
}
