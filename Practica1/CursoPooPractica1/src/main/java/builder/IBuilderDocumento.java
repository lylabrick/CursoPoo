package builder;

// IBuilderDocumento.java
public interface IBuilderDocumento {
    IBuilderDocumento setTitulo(String titulo);
    IBuilderDocumento addSeccion(String titulo, String contenido);
    IBuilderDocumento addSeccion(ISeccion seccion);
    IBuilderDocumento setPieDePagina(String pie);
    IBuilderDocumento addMetadato(String clave, String valor);
    IBuilderDocumento conTablaDeContenidos();
    IDocumento build();
}