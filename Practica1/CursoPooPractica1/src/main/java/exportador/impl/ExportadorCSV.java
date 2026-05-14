package exportador.impl;

import exportador.Exportador;
import fomateador.Formateador;
import fomateador.impl.FormateadorCSV;

public class ExportadorCSV extends Exportador {

    @Override
    protected Formateador crearFormateador() {
        return new FormateadorCSV();
    }
}
