package abstractfactoryui.uicomponent.oscuro;

import abstractfactoryui.uicomponent.CampoTexto;

// CampoTextoOscuro.java
public class CampoTextoOscuro implements CampoTexto {

    @Override
    public void renderizar() {
        System.out.println("[OSCURO] CampoTexto: fondo=#2A2A2A borde=#444444 placeholder gris claro");
    }

    @Override
    public void alEscribir(String texto) {
        System.out.println("[OSCURO] CampoTexto: texto ingresado → " + texto);
    }
}
