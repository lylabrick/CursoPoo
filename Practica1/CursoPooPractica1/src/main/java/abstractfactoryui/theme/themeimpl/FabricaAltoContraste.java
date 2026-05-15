package abstractfactoryui.theme.themeimpl;

import abstractfactoryui.theme.FabricaTema;
import abstractfactoryui.uicomponent.Boton;
import abstractfactoryui.uicomponent.CampoTexto;
import abstractfactoryui.uicomponent.Panel;
import abstractfactoryui.uicomponent.altocontraste.BotonAltoContraste;
import abstractfactoryui.uicomponent.altocontraste.CampoTextoAltoContraste;
import abstractfactoryui.uicomponent.altocontraste.PanelAltoContraste;

public class FabricaAltoContraste  implements FabricaTema {

    @Override
    public Boton crearBoton() {
        return new BotonAltoContraste();
    }

    @Override
    public CampoTexto crearCampoTexto() {
        return new CampoTextoAltoContraste();
    }

    @Override
    public Panel crearPanel() {
        return new PanelAltoContraste();
    }
}
