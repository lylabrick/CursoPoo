package abstractfactoryui.uicomponent.claro;

// PanelClaro.java
import abstractfactoryui.uicomponent.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelClaro implements Panel {

    private final List<String> componentes = new ArrayList<>();

    @Override
    public void renderizar() {
        System.out.println("[CLARO] Panel: fondo=#F0F0F0 sombra suave bordes redondeados");
        componentes.forEach(c -> System.out.println("         └─ " + c));
    }

    @Override
    public void agregarComponente(String nombre) {
        componentes.add(nombre);
    }
}