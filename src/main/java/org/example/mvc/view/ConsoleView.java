package org.example.mvc.view;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void printLine(String text) {
        System.out.println(text);
    }

    public int readInt(String prompt) {
        while (true) {
            printLine(prompt);
            String value = scanner.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                printLine("Entrada inválida. Debe ser un entero.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            printLine(prompt);
            String value = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException ex) {
                printLine("Entrada inválida. Debe ser un número decimal.");
            }
        }
    }

    public boolean readBoolean(String prompt) {
        while (true) {
            printLine(prompt + " (true/false, si/no, 1/0)");
            String value = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            if ("true".equals(value) || "si".equals(value) || "1".equals(value)) {
                return true;
            }
            if ("false".equals(value) || "no".equals(value) || "0".equals(value)) {
                return false;
            }
            printLine("Entrada inválida. Debe ser un valor booleano.");
        }
    }

    public String readString(String prompt) {
        while (true) {
            printLine(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            printLine("Entrada inválida. No puede estar vacía.");
        }
    }

    public void close() {
        scanner.close();
    }
}
