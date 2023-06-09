
# Cliente/Servidor REST con Jersey

Esta parte del taller corresponde a la implementación de un servidor REST para manejar paseos, así como un cliente para probar el servidor.

## Servidor

El [servidor REST](/jersey/jersey-server/) está desarrollado con Java Jersey.

### Requisitos

- Java 17+ y la variable de entorno `JAVA_HOME` configurada
- Maven 3.8.1+

### Ejecución

Entrar a la carpeta `jersey-server`

```bash
cd jersey-server
```

Compilar con Maven

```bash
mvn clean install
``` 

Ejecutar el servidor

```bash
mvn exec:java
```

## Cliente GUI JavaFX

El [cliente GUI](/jersey/jersey-client-fx/) está desarrollado con JavaFX + Jersey. Al ser un cliente GUI, es una aplicación de escritorio.

### Requisitos

- Java 17+ y la variable de entorno `JAVA_HOME` configurada
- Maven 3.8.1+

### Ejecución

El servidor debe estar ejecutándose. Si no está ejecutándose, habrá un error de conexión.

Entrar a la carpeta `jersey-client-fx`

```bash
cd jersey-client-fx
```

Compilar y ejecutar con Maven

```bash
mvn clean javafx:run
```

## Cliente Programático

También se incluye un [cliente programático](/jersey/jersey-client/) simple para probar el servidor. Este cliente está desarrollado con Java Jersey.

### Requisitos

- Java 17+ y la variable de entorno `JAVA_HOME` configurada
- Maven 3.8.1+

### Ejecución

El servidor debe estar ejecutándose. Si no está ejecutándose, habrá un error de conexión.

Entrar a la carpeta `jersey-client`

```bash
cd jersey-client
```

Compilar con Maven

```bash
mvn clean install
```

Ejecutar el cliente

```bash
mvn exec:java
```
