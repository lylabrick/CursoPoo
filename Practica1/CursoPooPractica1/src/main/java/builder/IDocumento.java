package builder;

// IDocumento.java
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IDocumento {
    Optional<String> getTitulo();
    List<ISeccion> getSecciones();
    Optional<String> getPieDePagina();
    Map<String, String> getMetadatos();
    boolean tieneTablaDeContenidos();
}