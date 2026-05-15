package abstractfactoryui.uicomponent.oscuro;

// PanelOscuro.java
import abstractfactoryui.uicomponent.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelOscuro implements Panel {

    private final List<String> componentes = new ArrayList<>();

    @Override
    public void renderizar() {
        System.out.println("[OSCURO] Panel: fondo=#121212 sombra profunda bordes sutiles");
        componentes.forEach(c -> System.out.println("         └─ " + c));
    }

    @Override
    public void agregarComponente(String nombre) {
        componentes.add(nombre);
    }
}
