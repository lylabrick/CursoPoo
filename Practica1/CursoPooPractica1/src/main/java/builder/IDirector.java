package builder;

// IDirector.java
public interface IDirector {
    IDocumento construirInformeEjecutivo(String empresa, String periodo);
    IDocumento construirActaReunion(String asunto, String[] participantes);
}