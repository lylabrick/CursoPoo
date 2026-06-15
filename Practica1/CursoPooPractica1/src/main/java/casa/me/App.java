package casa.me;

import builder.IDirector;
import builder.IDocumento;
import builder.impl.BuilderDocumento;
import builder.impl.DirectorDocumentos;

// Main.java
public class App {

    public static void main(String[] args) {

        // ── 1. Builder directo ─────────────────────────────────────────────────
        System.out.println("\n>>> 1. USO DIRECTO DEL BUILDER\n");

        IDocumento manual = new BuilderDocumento()
                .setTitulo("Manual de Onboarding")
                .addMetadato("Autor",    "RRHH")
                .addMetadato("Revisión", "2025-01")
                .conTablaDeContenidos()
                .addSeccion("Bienvenida",    "Cultura y valores de la empresa.")
                .addSeccion("Herramientas",  "Accesos, cuentas y software necesario.")
                .addSeccion("Primer semana", "Agenda sugerida para los primeros 5 días.")
                .setPieDePagina("Recursos Humanos — Uso interno")
                .build();

        System.out.println(manual);

        // ── 2. Director — Informe ejecutivo ────────────────────────────────────
        System.out.println("\n>>> 2. DIRECTOR — Informe ejecutivo\n");

        IDirector director = new DirectorDocumentos(new BuilderDocumento());

        IDocumento informe = director.construirInformeEjecutivo("Acme Corp", "Q1 2025");
        System.out.println(informe);

        // ── 3. Director — Acta de reunión ──────────────────────────────────────
        System.out.println("\n>>> 3. DIRECTOR — Acta de reunión\n");

        IDocumento acta = new DirectorDocumentos(new BuilderDocumento())
                .construirActaReunion(
                        "Planificación Sprint 12",
                        new String[]{"Ana Gómez", "Luis Herrera", "María Paz"}
                );
        System.out.println(acta);
    }
}
