package casa.me;
// Main.java

import exportador.Exportador;
import exportador.impl.ExportadorCSV;
import exportador.impl.ExportadorHTML;
import exportador.impl.ExportadorMarkdown;
import exportador.impl.ExportadorPDF;

import java.util.List;

public class App {


    public static void main(String[] args) {

        String titulo    = "Informe Académico UNLP 2026";
        String cuerpo    = "Este informe resume los resultados del primer cuatrimestre.";
        String[] secciones = { "Introducción", "Metodología", "Resultados", "Conclusiones" };

        // ── Código cliente: solo conoce Exportador ──
        // No sabe nada de Formateador ni de sus implementaciones.
        // Para agregar CSV bastó crear dos clases nuevas,
        // sin modificar Main ni Exportador.
        List<Exportador> exportadores = List.of(
                new ExportadorPDF(),
                new ExportadorHTML(),
                new ExportadorMarkdown(),
                new ExportadorCSV()     // nuevo formato — cero cambios en el cliente
        );

        for (Exportador exportador : exportadores) {
            System.out.println("─".repeat(50));
            String resultado = exportador.exportarDocumento(titulo, cuerpo, secciones);
            System.out.println(resultado);
        }
    }
}