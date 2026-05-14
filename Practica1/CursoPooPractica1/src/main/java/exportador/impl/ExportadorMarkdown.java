package exportador.impl;

import exportador.Exportador;
import fomateador.Formateador;
import fomateador.impl.FormateadorMarkdown;

// ExportadorMarkdown.java
public class ExportadorMarkdown extends Exportador {

    @Override
    protected Formateador crearFormateador() {
        return new FormateadorMarkdown();
    }
}