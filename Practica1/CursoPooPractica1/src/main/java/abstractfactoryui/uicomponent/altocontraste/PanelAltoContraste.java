package abstractfactoryui.uicomponent.altocontraste;

import abstractfactoryui.uicomponent.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelAltoContraste implements Panel {

    private final List<String> componentes = new ArrayList<>();

    @Override
    public void renderizar() {
        System.out.println("[ALTO CONTRASTE] Panel: fondo=#000000 sombra fuerte bordes definidos");
        componentes.forEach(c -> System.out.println("         └─ " + c));
    }

    @Override
    public void agregarComponente(String nombre) {
        componentes.add(nombre);
    }

}
