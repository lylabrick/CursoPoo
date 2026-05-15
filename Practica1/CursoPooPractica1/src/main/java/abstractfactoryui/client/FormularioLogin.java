package abstractfactoryui.client;

// ── Cliente ────────────────────────────────────

import abstractfactoryui.theme.FabricaTema;
import abstractfactoryui.uicomponent.Boton;
import abstractfactoryui.uicomponent.CampoTexto;
import abstractfactoryui.uicomponent.Panel;

// FormularioLogin.java
// No importa ninguna clase concreta de tema.
// Solo conoce las interfaces y FabricaTema.
public class FormularioLogin {

    private final Boton botonIngresar;
    private final CampoTexto campoUsuario;
    private final CampoTexto campoPassword;
    private final Panel panel;

    // La fábrica se inyecta — el cliente no elige la familia
    public FormularioLogin(FabricaTema fabrica) {
        this.panel         = fabrica.crearPanel();
        this.campoUsuario  = fabrica.crearCampoTexto();
        this.campoPassword = fabrica.crearCampoTexto();
        this.botonIngresar = fabrica.crearBoton();

        panel.agregarComponente("CampoTexto: usuario");
        panel.agregarComponente("CampoTexto: password");
        panel.agregarComponente("Botón: ingresar");
    }

    public void mostrar() {
        System.out.println("\n── Renderizando formulario ──────────────");
        panel.renderizar();
    }

    public void simularInteraccion() {
        System.out.println("\n── Simulando interacción ────────────────");
        campoUsuario.alEscribir("laura@fi.unlp.edu.ar");
        campoPassword.alEscribir("********");
        botonIngresar.alHacerClick();
    }
}