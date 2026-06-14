package casa.me;

import abstractfactoryui.builderconclaseinterna.DirectorDocumentos;
import abstractfactoryui.builderconclaseinterna.Documento;

public class App {

    public static void main(String[] args) {

        System.out.println("\n>>> 1. USO DIRECTO DEL BUILDER (interfaz fluida)\n");

        Documento docPersonalizado = new Documento.BuilderDocumento()
                .setTitulo("Manual de Onboarding")
                .addMetadato("Autor", "RRHH")
                .addMetadato("Revisión", "2025-01")
                .conTablaDeContenidos()
                .addSeccion("Bienvenida", "Descripción de la cultura y valores de la empresa.")
                .addSeccion("Herramientas", "Accesos, cuentas y software necesario.")
                .addSeccion("Primer semana", "Agenda sugerida para los primeros 5 días.")
                .setPieDePagina("Recursos Humanos — Uso interno")
                .build();

        System.out.println(docPersonalizado);

        System.out.println("\n>>> 2. DIRECTOR — Informe ejecutivo\n");

        DirectorDocumentos director = new DirectorDocumentos(
                new Documento.BuilderDocumento()   // Builder fresco para cada documento
        );

        Documento informe = director.construirInformeEjecutivo(
                "Acme Corp", "Q1 2025"
        );
        System.out.println(informe);


        System.out.println("\n>>> 3. DIRECTOR — Acta de reunión\n");

        Documento acta = new DirectorDocumentos(new Documento.BuilderDocumento())
                .construirActaReunion(
                        "Planificación Sprint 12",
                        new String[]{"Ana Gómez", "Luis Herrera", "María Paz"}
                );
        System.out.println(acta);
    }
}
