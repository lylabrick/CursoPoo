package exportador;

import fomateador.Formateador;

public abstract class Exportador {

    // ── Factory Method ──────────────────────────
    // Cada subclase decide qué formateador crear.
    // El código de exportarDocumento() no sabe
    // ni le importa cuál es el tipo concreto.
    protected abstract Formateador crearFormateador();

    // ── Algoritmo de exportación (común a todos) ─
    public String exportarDocumento(String titulo, String cuerpo, String[] secciones) {
        Formateador formateador = crearFormateador();   // delega la creación

        StringBuilder documento = new StringBuilder();
        documento.append(formateador.formatearTitulo(titulo)).append("\n\n");
        documento.append(formateador.formatearParrafo(cuerpo)).append("\n\n");
        documento.append(formateador.formatearLista(secciones)).append("\n");

        String nombreArchivo = titulo.toLowerCase().replace(" ", "_")
                + formateador.obtenerExtension();

        System.out.println("Generando: " + nombreArchivo);
        return documento.toString();
    }
}
