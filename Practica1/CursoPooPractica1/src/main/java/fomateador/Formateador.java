package fomateador;

// Formateador.java
public interface Formateador {
    String formatearTitulo(String titulo);
    String formatearParrafo(String texto);
    String formatearLista(String[] items);
    String obtenerExtension();
}