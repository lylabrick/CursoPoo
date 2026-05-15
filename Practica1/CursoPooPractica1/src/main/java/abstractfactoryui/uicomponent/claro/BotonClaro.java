package abstractfactoryui.uicomponent.claro;

import abstractfactoryui.uicomponent.Boton;

public class BotonClaro implements Boton {
    @Override
    public void renderizar() {

        System.out.println("[CLARO] Botón: fondo=#FFFFFF borde=#CCCCCC texto=#000000");
    }

    @Override
    public void alHacerClick() {

        System.out.println("[CLARO] Botón: efecto ripple suave gris claro");
    }
}
