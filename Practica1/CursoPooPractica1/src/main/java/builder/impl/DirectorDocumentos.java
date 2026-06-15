package builder.impl;

// DirectorDocumentos.java
import builder.IBuilderDocumento;
import builder.IDirector;
import builder.IDocumento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DirectorDocumentos implements IDirector {

    private final IBuilderDocumento builder;

    public DirectorDocumentos(IBuilderDocumento builder) {
        this.builder = builder;
    }

    @Override
    public IDocumento construirInformeEjecutivo(String empresa, String periodo) {
        return builder
                .setTitulo("Informe Ejecutivo — " + empresa)
                .addMetadato("Empresa", empresa)
                .addMetadato("Período", periodo)
                .addMetadato("Fecha",   LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .addMetadato("Versión", "1.0")
                .conTablaDeContenidos()
                .addSeccion("Resumen ejecutivo",
                        "Síntesis de los resultados más relevantes del período " + periodo + ".")
                .addSeccion("Resultados financieros",
                        "Análisis de ingresos, egresos y márgenes operativos.")
                .addSeccion("Indicadores clave (KPI)",
                        "Métricas de desempeño comparadas contra objetivos.")
                .addSeccion("Riesgos y oportunidades",
                        "Identificación de factores críticos para el próximo período.")
                .addSeccion("Conclusiones y recomendaciones",
                        "Acciones sugeridas para la dirección.")
                .setPieDePagina("Confidencial — " + empresa + " © " + LocalDate.now().getYear())
                .build();
    }

    @Override
    public IDocumento construirActaReunion(String asunto, String[] participantes) {
        String lista = String.join(", ", participantes);

        return builder
                .setTitulo("Acta de Reunión — " + asunto)
                .addMetadato("Asunto",        asunto)
                .addMetadato("Fecha",         LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .addMetadato("Participantes", lista)
                .addSeccion("Apertura",
                        "Se da inicio a la reunión con la presencia de: " + lista + ".")
                .addSeccion("Temas tratados",
                        "1. Revisión del estado actual.\n  2. Definición de próximos pasos.")
                .addSeccion("Acuerdos y compromisos",
                        "Tareas asignadas con responsables y fechas límite.")
                .addSeccion("Próxima reunión",
                        "A coordinar según disponibilidad de los participantes.")
                .setPieDePagina("Acta aprobada por los presentes — " +
                        LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .build();
    }
}