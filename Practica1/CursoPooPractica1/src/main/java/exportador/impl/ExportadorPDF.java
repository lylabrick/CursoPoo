package exportador.impl;

import exportador.Exportador;
import fomateador.Formateador;
import fomateador.impl.FormateadorPDF;

// ExportadorPDF.java
public class ExportadorPDF extends Exportador {

    @Override
    protected Formateador crearFormateador() {
        return new FormateadorPDF();
    }
}