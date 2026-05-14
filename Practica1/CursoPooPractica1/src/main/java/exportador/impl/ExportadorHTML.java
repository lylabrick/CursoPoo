package exportador.impl;

import exportador.Exportador;
import fomateador.Formateador;
import fomateador.impl.FormateadorHTML;


// ExportadorHTML.java
public class ExportadorHTML extends Exportador {

    @Override
    protected Formateador crearFormateador() {
        return new FormateadorHTML();
    }

}
