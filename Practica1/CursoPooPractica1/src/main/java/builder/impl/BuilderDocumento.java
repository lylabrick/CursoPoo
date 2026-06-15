package builder.impl;

import builder.IBuilderDocumento;
import builder.IDocumento;
import builder.ISeccion;

// BuilderDocumento.java
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BuilderDocumento implements IBuilderDocumento {

    private String titulo                        = null;
    private final List<ISeccion> secciones       = new ArrayList<>();
    private String pieDePagina                   = null;
    private final Map<String, String> metadatos  = new LinkedHashMap<>();
    private boolean incluirTablaDeContenidos     = false;

    @Override
    public IBuilderDocumento setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    @Override
    public IBuilderDocumento addSeccion(String titulo, String contenido) {
        this.secciones.add(new Seccion(titulo, contenido));
        return this;
    }

    @Override
    public IBuilderDocumento addSeccion(ISeccion seccion) {
        this.secciones.add(seccion);
        return this;
    }

    @Override
    public IBuilderDocumento setPieDePagina(String pie) {
        this.pieDePagina = pie;
        return this;
    }

    @Override
    public IBuilderDocumento addMetadato(String clave, String valor) {
        this.metadatos.put(clave, valor);
        return this;
    }

    @Override
    public IBuilderDocumento conTablaDeContenidos() {
        this.incluirTablaDeContenidos = true;
        return this;
    }

    @Override
    public IDocumento build() {
        if (titulo == null && secciones.isEmpty())
            throw new IllegalStateException("El documento debe tener al menos título o una sección.");

        return new Documento(titulo, secciones, pieDePagina, metadatos, incluirTablaDeContenidos);
    }
}