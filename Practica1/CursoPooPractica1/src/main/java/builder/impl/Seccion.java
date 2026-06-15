package builder.impl;

import builder.ISeccion;

// Seccion.java
public class Seccion implements ISeccion {

    private final String titulo;
    private final String contenido;

    public Seccion(String titulo, String contenido) {
        if (titulo == null || titulo.isBlank())
            throw new IllegalArgumentException("El título de la sección no puede estar vacío.");
        this.titulo    = titulo;
        this.contenido = contenido != null ? contenido : "";
    }

    @Override public String getTitulo()    { return titulo; }
    @Override public String getContenido() { return contenido; }

    @Override
    public String toString() {
        return "  [" + titulo + "]\n  " + contenido;
    }
}