package fomateador.impl;

import fomateador.Formateador;

public class FormateadorPDF implements Formateador {

    @Override
    public String formatearTitulo(String titulo) {
        return "[PDF-TITULO] " + titulo.toUpperCase();
    }

    @Override
    public String formatearParrafo(String texto) {
        return "[PDF-PARRAFO] " + texto;
    }

    @Override
    public String formatearLista(String[] items) {
        StringBuilder sb = new StringBuilder("[PDF-LISTA]\n");
        for (String item : items) {
            sb.append("  • ").append(item).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String obtenerExtension() { return ".pdf"; }
}
