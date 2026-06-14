package abstractfactoryui.builderconclaseinterna;

import java.util.*;

public class Documento {

    private final String titulo;
    private final List<Seccion> secciones;
    private final String pieDePagina;
    private final Map<String, String> metadatos;
    private final boolean incluirTablaDeContenidos;

    // Constructor privado: solo el Builder puede instanciar
    private Documento(BuilderDocumento builder) {
        this.titulo                  = builder.titulo;
        this.secciones               = Collections.unmodifiableList(builder.secciones);
        this.pieDePagina             = builder.pieDePagina;
        this.metadatos               = Collections.unmodifiableMap(builder.metadatos);
        this.incluirTablaDeContenidos = builder.incluirTablaDeContenidos;
    }

    // ── Getters ────────────────────────────────────────────────────────────────

    public Optional<String> getTitulo()        { return Optional.ofNullable(titulo); }
    public List<Seccion>    getSecciones()      { return secciones; }
    public Optional<String> getPieDePagina()   { return Optional.ofNullable(pieDePagina); }
    public Map<String, String> getMetadatos()  { return metadatos; }
    public boolean tieneTablaDeContenidos()    { return incluirTablaDeContenidos; }

    // ── Representación ─────────────────────────────────────────────────────────

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("═".repeat(60)).append("\n");

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

    // ══════════════════════════════════════════════════════════════════════════
    // Clase interna: Seccion
    // ══════════════════════════════════════════════════════════════════════════

    public static class Seccion {
        private final String titulo;
        private final String contenido;

        public Seccion(String titulo, String contenido) {
            if (titulo == null || titulo.isBlank())
                throw new IllegalArgumentException("El título de la sección no puede estar vacío.");
            this.titulo    = titulo;
            this.contenido = contenido != null ? contenido : "";
        }

        public String getTitulo()    { return titulo; }
        public String getContenido() { return contenido; }

        @Override
        public String toString() {
            return "  [" + titulo + "]\n  " + contenido + "\n";
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    // Builder con interfaz fluida
    // ══════════════════════════════════════════════════════════════════════════

    public static class BuilderDocumento {

        // Todos los campos son opcionales: valores por defecto seguros
        private String titulo                   = null;
        private final List<Seccion> secciones   = new ArrayList<>();
        private String pieDePagina              = null;
        private final Map<String, String> metadatos = new LinkedHashMap<>();
        private boolean incluirTablaDeContenidos = false;

        public BuilderDocumento setTitulo(String titulo) {
            this.titulo = titulo;
            return this;   // ← devuelve this para encadenamiento fluido
        }

        public BuilderDocumento addSeccion(String titulo, String contenido) {
            this.secciones.add(new Seccion(titulo, contenido));
            return this;
        }

        public BuilderDocumento addSeccion(Seccion seccion) {
            this.secciones.add(seccion);
            return this;
        }

        public BuilderDocumento setPieDePagina(String pie) {
            this.pieDePagina = pie;
            return this;
        }

        public BuilderDocumento addMetadato(String clave, String valor) {
            this.metadatos.put(clave, valor);
            return this;
        }

        public BuilderDocumento conTablaDeContenidos() {
            this.incluirTablaDeContenidos = true;
            return this;
        }

        public Documento build() {
            // Validaciones de negocio centralizadas en un solo lugar
            if (secciones.isEmpty() && titulo == null)
                throw new IllegalStateException("Un documento debe tener al menos título o una sección.");
            return new Documento(this);
        }
    }
}
