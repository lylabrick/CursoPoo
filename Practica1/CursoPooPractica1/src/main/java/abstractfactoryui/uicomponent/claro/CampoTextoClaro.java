package abstractfactoryui.uicomponent.claro;

import abstractfactoryui.uicomponent.CampoTexto;

// CampoTextoClaro.java
public class CampoTextoClaro implements CampoTexto {

    @Override
    public void renderizar() {
        System.out.println("[CLARO] CampoTexto: fondo=#F9F9F9 borde=#DDDDDD placeholder gris");
    }

    @Override
    public void alEscribir(String texto) {
        System.out.println("[CLARO] CampoTexto: texto ingresado → " + texto);
    }
}