package casa.me;

import abstractfactoryui.client.FormularioLogin;
import abstractfactoryui.configtheme.SelectorTema;
import abstractfactoryui.theme.FabricaTema;

public class App {
    public static void main(String[] args) {

        // Simular que el tema viene de configuración externa
        String[] temas = { "claro", "oscuro" , "altocontraste" };

        for (String nombreTema : temas) {
            System.out.println("═".repeat(60));
            System.out.println("  Tema: " + nombreTema.toUpperCase());
            System.out.println("═".repeat(60));

            FabricaTema fabrica = SelectorTema.obtener(nombreTema);

            // FormularioLogin no sabe qué tema está usando
            FormularioLogin formulario = new FormularioLogin(fabrica);
            formulario.mostrar();
            formulario.simularInteraccion();
        }
    }
}