## Cliente Programático

El cliente programático es un cliente simple para probar el servidor. Este cliente está desarrollado con Java Jersey.

### Requisitos

- Java 17+ y la variable de entorno `JAVA_HOME` configurada
- Maven 3.8.1+

### Ejecución

El servidor debe estar ejecutándose. Si no está ejecutándose, habrá un error de conexión.

Compilar con Maven

```bash
mvn clean install
```

Ejecutar el cliente

```bash
mvn exec:java
```
