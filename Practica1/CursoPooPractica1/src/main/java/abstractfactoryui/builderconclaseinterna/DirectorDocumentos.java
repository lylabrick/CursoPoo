package abstractfactoryui.builderconclaseinterna;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * El Director conoce recetas concretas de construcción.
 * No sabe CÓMO se construye (eso es del Builder),
 * sino QUÉ combinación de pasos produce cada tipo de documento.
 */
public class DirectorDocumentos {

    private final Documento.BuilderDocumento builder;

    public DirectorDocumentos(Documento.BuilderDocumento builder) {
        this.builder = builder;
    }

    // ── Receta 1: Informe ejecutivo ────────────────────────────────────────────

    public Documento construirInformeEjecutivo(String empresa, String periodo) {
        return builder
                .setTitulo("Informe Ejecutivo — " + empresa)
                .addMetadato("Empresa",  empresa)
                .addMetadato("Período",  periodo)
                .addMetadato("Fecha",    LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .addMetadato("Versión",  "1.0")
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
                .setPieDePagina("Confidencial — " + empresa + " © " +
                        LocalDate.now().getYear())
                .build();
    }

    // ── Receta 2: Acta de reunión ──────────────────────────────────────────────

    public Documento construirActaReunion(String asunto, String[] participantes) {
        String listaParticipantes = String.join(", ", participantes);

        return builder
                .setTitulo("Acta de Reunión — " + asunto)
                .addMetadato("Asunto",         asunto)
                .addMetadato("Fecha",          LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .addMetadato("Participantes",  listaParticipantes)
                .addSeccion("Apertura",
                        "Se da inicio a la reunión con la presencia de: " + listaParticipantes + ".")
                .addSeccion("Temas tratados",
                        "1. Revisión del estado actual.\n  2. Definición de próximos pasos.")
                .addSeccion("Acuerdos y compromisos",
                        "Se detallan las tareas asignadas y sus responsables.")
                .addSeccion("Próxima reunión",
                        "A coordinar según disponibilidad de los participantes.")
                .setPieDePagina("Acta aprobada por los presentes — Fecha: " +
                        LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .build();
    }
}