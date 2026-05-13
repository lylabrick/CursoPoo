package casa.me;
// Main.java

import singleton.ConfiguracionApp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Demo Singleton ===\n");

        // ── 1. Uso básico ──────────────────────────────
        ConfiguracionApp config = ConfiguracionApp.getInstancia();
        config.setHost("produccion.unlp.edu.ar");
        config.setPuerto(443);
        config.setModoDebug(true);

        System.out.println("Instancia 1: " + config);

        // Obtener de nuevo — debe ser la misma instancia
        ConfiguracionApp config2 = ConfiguracionApp.getInstancia();
        System.out.println("Instancia 2: " + config2);
        System.out.println("¿Son la misma instancia? " + (config == config2));

        // ── 2. Prueba con múltiples threads ────────────
        System.out.println("\n=== Prueba con 10 threads concurrentes ===\n");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final int numero = i;
            pool.submit(() -> {
                ConfiguracionApp c = ConfiguracionApp.getInstancia();
                System.out.printf("Thread %d obtuvo instancia@%s%n",
                        numero, Integer.toHexString(System.identityHashCode(c)));
            });
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        // Todos los hashcodes deben ser iguales — una sola instancia
    }
}