package fomateador.impl;

import fomateador.Formateador;

public class FormateadorCSV implements Formateador {

    @Override
    public String formatearTitulo(String titulo) {
        return "TITULO," + titulo;
    }

    @Override
    public String formatearParrafo(String texto) {
        return "PARRAFO,\"" + texto + "\"";
    }

    @Override
    public String formatearLista(String[] items) {
        return "LISTA," + String.join(",", items);
    }

    @Override
    public String obtenerExtension() { return ".csv"; }
}