package abstractfactoryui.theme;

// ── Abstract Factory ───────────────────────────

import abstractfactoryui.uicomponent.Boton;
import abstractfactoryui.uicomponent.CampoTexto;
import abstractfactoryui.uicomponent.Panel;

// FabricaTema.java
public interface FabricaTema {
    Boton crearBoton();
    CampoTexto crearCampoTexto();
    Panel crearPanel();
}