1.	Singleton — Gestor de configuración global. Implementar una clase
ConfiguracionApp que garantice una única instancia durante toda la ejecución.
Analizar por qué la implementación naïve no es thread-safe y corregirla usando
inicialización diferida con doble verificación. Discutir cuándo Singleton es un
antipatrón y cuándo es legítimo.

Cuándo Singleton es legítimo:

Configuración global de la aplicación
Pool de conexiones a base de datos
Logger centralizado
Caché en memoria compartida

Cuándo es un antipatrón:

Cuando lo usás para evitar pasar dependencias correctamente (es estado global disfrazado)
Cuando dificulta el testing porque no podés reemplazarlo por un mock
Cuando hay múltiples contextos de ejecución (múltiples classloaders, microservicios) donde la "única instancia" deja de serlo
Cuando el objeto no tiene razón real de ser único y lo forzás por comodidad