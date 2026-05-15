package abstractfactoryui.configtheme;

// ── Selector de tema ───────────────────────────

import abstractfactoryui.theme.FabricaTema;
import abstractfactoryui.theme.themeimpl.FabricaAltoContraste;
import abstractfactoryui.theme.themeimpl.FabricaTemaClaro;
import abstractfactoryui.theme.themeimpl.FabricaTemaOscuro;

// SelectorTema.java
// Único lugar donde se menciona una clase concreta.
// Podría leer el tema desde un archivo de config o variable de entorno.
public class SelectorTema {

    public static FabricaTema obtener(String tema) {
        return switch (tema.toLowerCase()) {
            case "oscuro" -> new FabricaTemaOscuro();
            case "claro"  -> new FabricaTemaClaro();
            case "altocontraste" -> new FabricaAltoContraste();
            // Para agregar TemaAltoContraste:
            // case "alto-contraste" -> new FabricaTemaAltoContraste();
            default -> throw new IllegalArgumentException("Tema desconocido: " + tema);
        };
    }
}