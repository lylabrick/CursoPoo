package abstractfactoryui.uicomponent.oscuro;

// ── Tema Oscuro ────────────────────────────────

import abstractfactoryui.uicomponent.Boton;

// BotonOscuro.java
public class BotonOscuro implements Boton {

    @Override
    public void renderizar() {

        System.out.println("[OSCURO] Botón: fondo=#1E1E1E borde=#555555 texto=#E0E0E0");
    }

    @Override
    public void alHacerClick() {

        System.out.println("[OSCURO] Botón: efecto glow azul neón");
    }
}
