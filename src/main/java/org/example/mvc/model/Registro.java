package org.example.mvc.model;

public class Registro {
    private final int id;
    private final String nombre;
    private final double nota;
    private final boolean activo;

    public Registro(int id, String nombre, double nota, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.nota = nota;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public boolean isActivo() {
        return activo;
    }
}
