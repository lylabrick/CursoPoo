package fomateador.impl;

import fomateador.Formateador;

// FormateadorMarkdown.java
public class FormateadorMarkdown implements Formateador {

    @Override
    public String formatearTitulo(String titulo) {
        return "# " + titulo;
    }

    @Override
    public String formatearParrafo(String texto) {
        return texto + "\n";
    }

    @Override
    public String formatearLista(String[] items) {
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append("- ").append(item).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String obtenerExtension() { return ".md"; }
}