package builder.impl;

// Documento.java
import builder.IDocumento;
import builder.ISeccion;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Documento implements IDocumento {

    private final String titulo;
    private final List<ISeccion> secciones;
    private final String pieDePagina;
    private final Map<String, String> metadatos;
    private final boolean incluirTablaDeContenidos;

    // Solo BuilderDocumento puede construirlo
    Documento(String titulo,
              List<ISeccion> secciones,
              String pieDePagina,
              Map<String, String> metadatos,
              boolean incluirTablaDeContenidos) {

        this.titulo                   = titulo;
        this.secciones                = Collections.unmodifiableList(secciones);
        this.pieDePagina              = pieDePagina;
        this.metadatos                = Collections.unmodifiableMap(metadatos);
        this.incluirTablaDeContenidos = incluirTablaDeContenidos;
    }

    @Override public Optional<String>      getTitulo()              { return Optional.ofNullable(titulo); }
    @Override public List<ISeccion>        getSecciones()           { return secciones; }
    @Override public Optional<String>      getPieDePagina()         { return Optional.ofNullable(pieDePagina); }
    @Override public Map<String, String>   getMetadatos()           { return metadatos; }
    @Override public boolean               tieneTablaDeContenidos() { return incluirTablaDeContenidos; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.repeat("=",60).append("\n");
        getTitulo().ifPresent(t ->
                sb.append("  DOCUMENTO: ").append(t.toUpperCase()).append("\n")
                        .append("─".repeat(60)).append("\n")
        );

        if (!metadatos.isEmpty()) {
            sb.append("  Metadatos:\n");
            metadatos.forEach((k, v) ->
                    sb.append("    • ").append(k).append(": ").append(v).append("\n")
            );
            sb.append("─".repeat(60)).append("\n");
        }

        if (incluirTablaDeContenidos && !secciones.isEmpty()) {
            sb.append("  TABLA DE CONTENIDOS\n");
            for (int i = 0; i < secciones.size(); i++) {
                sb.append("    ").append(i + 1).append(". ")
                        .append(secciones.get(i).getTitulo()).append("\n");
            }
            sb.append("─".repeat(60)).append("\n");
        }

        secciones.forEach(s -> sb.append(s).append("\n"));

        getPieDePagina().ifPresent(p ->
                sb.append("─".repeat(60)).append("\n")
                        .append("  ").append(p).append("\n")
        );

        sb.append("═".repeat(60));
        return sb.toString();
    }
}
