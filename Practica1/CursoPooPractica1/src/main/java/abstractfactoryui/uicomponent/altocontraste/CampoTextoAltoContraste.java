package abstractfactoryui.uicomponent.altocontraste;

import abstractfactoryui.uicomponent.CampoTexto;

public class CampoTextoAltoContraste implements CampoTexto {

    @Override
    public void renderizar() {
        System.out.println("[ALTO CONTRASTE] CampoTexto: fondo=#000000 borde=#FFFFFF placeholder blanco");
    }

    @Override
    public void alEscribir(String texto) {
        System.out.println("[ALTO CONTRASTE] CampoTexto: texto ingresado → " + texto);
    }
}
