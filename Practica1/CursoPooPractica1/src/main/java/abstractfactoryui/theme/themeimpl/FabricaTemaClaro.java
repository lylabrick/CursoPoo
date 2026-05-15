package abstractfactoryui.theme.themeimpl;

import abstractfactoryui.theme.FabricaTema;
import abstractfactoryui.uicomponent.Boton;
import abstractfactoryui.uicomponent.CampoTexto;
import abstractfactoryui.uicomponent.Panel;
import abstractfactoryui.uicomponent.claro.BotonClaro;
import abstractfactoryui.uicomponent.claro.CampoTextoClaro;
import abstractfactoryui.uicomponent.claro.PanelClaro;

// FabricaTemaClaro.java
public class FabricaTemaClaro implements FabricaTema {

    @Override
    public Boton crearBoton() {
        return new BotonClaro();
    }

    @Override
    public CampoTexto crearCampoTexto() {
        return new CampoTextoClaro();
    }

    @Override
    public Panel crearPanel() {
        return new PanelClaro();
    }
}