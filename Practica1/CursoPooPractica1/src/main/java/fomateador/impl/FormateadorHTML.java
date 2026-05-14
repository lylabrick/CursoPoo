package fomateador.impl;

import fomateador.Formateador;

// FormateadorHTML.java
public class FormateadorHTML implements Formateador {

    @Override
    public String formatearTitulo(String titulo) {
        return "<h1>" + titulo + "</h1>";
    }

    @Override
    public String formatearParrafo(String texto) {
        return "<p>" + texto + "</p>";
    }

    @Override
    public String formatearLista(String[] items) {
        StringBuilder sb = new StringBuilder("<ul>\n");
        for (String item : items) {
            sb.append("  <li>").append(item).append("</li>\n");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    @Override
    public String obtenerExtension() { return ".html"; }
}