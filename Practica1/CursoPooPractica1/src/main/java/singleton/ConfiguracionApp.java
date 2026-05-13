package singleton;

// ConfiguracionApp.java
public class ConfiguracionApp {

    // volatile garantiza visibilidad entre threads
    private static volatile ConfiguracionApp instancia;

    private String host;
    private int puerto;
    private String baseDatos;
    private boolean modoDebug;

    // constructor privado: nadie puede hacer new ConfiguracionApp()
    private ConfiguracionApp() {
        this.host       = "localhost";
        this.puerto     = 8080;
        this.baseDatos  = "appdb";
        this.modoDebug  = false;
        System.out.println("ConfiguracionApp inicializada — thread: "
                + Thread.currentThread().getName());
    }

    // ──────────────────────────────────────────
    // Versión NAÏVE — NO thread-safe
    // Si dos threads llegan aquí al mismo tiempo
    // cuando instancia == null, ambos crean una
    // instancia distinta (race condition).
    // ──────────────────────────────────────────
    public static ConfiguracionApp getInstanciaNaive() {
        if (instancia == null) {
            // <-- punto de carrera
            instancia = new ConfiguracionApp();
        }
        return instancia;
    }

    // ──────────────────────────────────────────
    // Versión CORRECTA — Double-Checked Locking
    // Primer if: evita sincronizar cuando ya
    //   está inicializado (caso común).
    // synchronized: solo un thread entra a la vez.
    // Segundo if: por si otro thread ya inicializó
    //   mientras esperaba el lock.
    // volatile: evita que la JVM reordene
    //   instrucciones y exponga un objeto
    //   parcialmente construido.
    // ──────────────────────────────────────────
    public static ConfiguracionApp getInstancia() {
        if (instancia == null) {                          // 1er check (sin lock)
            synchronized (ConfiguracionApp.class) {
                if (instancia == null) {                  // 2do check (con lock)
                    instancia = new ConfiguracionApp();
                }
            }
        }
        return instancia;
    }

    // getters
    public String getHost()       { return host; }
    public int    getPuerto()     { return puerto; }
    public String getBaseDatos()  { return baseDatos; }
    public boolean isModoDebug()  { return modoDebug; }

    // setters
    public void setHost(String host)          { this.host = host; }
    public void setPuerto(int puerto)         { this.puerto = puerto; }
    public void setBaseDatos(String bd)       { this.baseDatos = bd; }
    public void setModoDebug(boolean debug)   { this.modoDebug = debug; }

    @Override
    public String toString() {
        return String.format(
                "ConfiguracionApp { host='%s', puerto=%d, baseDatos='%s', debug=%b }",
                host, puerto, baseDatos, modoDebug
        );
    }
}
