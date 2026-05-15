package abstractfactoryui.uicomponent.altocontraste;

import abstractfactoryui.uicomponent.Boton;

public class BotonAltoContraste implements Boton {
        @Override
        public void renderizar() {
            System.out.println("[ALTO CONTRASTE] Renderizando un botón de alto contraste");
        }

        @Override
        public void alHacerClick() {
            System.out.println("[ALTO CONTRASTE] Alto de contraste hacer click");
        }
}
