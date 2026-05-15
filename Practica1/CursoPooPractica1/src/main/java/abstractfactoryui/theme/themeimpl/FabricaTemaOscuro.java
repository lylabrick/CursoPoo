package abstractfactoryui.theme.themeimpl;

import abstractfactoryui.theme.FabricaTema;
import abstractfactoryui.uicomponent.Boton;
import abstractfactoryui.uicomponent.CampoTexto;
import abstractfactoryui.uicomponent.Panel;
import abstractfactoryui.uicomponent.oscuro.BotonOscuro;
import abstractfactoryui.uicomponent.oscuro.CampoTextoOscuro;
import abstractfactoryui.uicomponent.oscuro.PanelOscuro;

// FabricaTemaOscuro.java
public class FabricaTemaOscuro implements FabricaTema {

    @Override
    public Boton crearBoton() {
        return new BotonOscuro();
    }

    @Override
    public CampoTexto crearCampoTexto() {
        return new CampoTextoOscuro();
    }

    @Override
    public Panel crearPanel() {
        return new PanelOscuro();
    }
}
