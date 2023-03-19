
# Calculadora - Microservicios

En esta parte del taller es posible evidenciar el funcionamiento de una calculadora mediante microservicios. Para esto, se hace uso de los siguientes servicios:

- Discovery -> Eureka
- Rest Services
    - Addition
    - Substraction
    - Multiplication
    - Division
- Rest Service -> Calculator (with load balancer)
- Client -> Browser
 


## Instrucciones de ejecución

1. Ejecutar Eureka
- ```mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Dserver.port=8761"```

2. Asegurar la ejecución de al menos una instancia para cada servicio (add, sub, mult, div).
- ```mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Dserver.port=9090"```
- ```mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Dserver.port=9091"```
- ```mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Dserver.port=9092"```
- ```mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Dserver.port=9093"```

3. Ejecutar Calculator
- ```mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Dserver.port=8888"```

4. Pruebas de funcionamiento (mediante postman):
- Addition
    - ```localhost:8888/calculator/addition1?a=100&b=1000&user=Carlos```
    - ```localhost:8888/calculator/addition1?a=1500&b=1230&user=Mariela```
    - ```localhost:8888/calculator/addition1?a=45&b=123&user=Jaime```
- Substraction
    - ```localhost:8888/calculator/subtraction1?a=100&b=1000&user=Julio```
    - ```localhost:8888/calculator/subtraction1?a=10000&b=156&user=Alexandra```
    - ```localhost:8888/calculator/subtraction1?a=3500&b=258&user=Leonardo```
- Multiplication
    - ```localhost:8888/calculator/division1?a=956&b=82&user=Camila```
    - ```localhost:8888/calculator/division1?a=96&b=2&user=Alejandro```
    - ```localhost:8888/calculator/division1?a=875&b=23&user=Jessica```
- Division
    - ```localhost:8888/calculator/multiplication1?a=90&b=500&user=Tatiana```
    - ```localhost:8888/calculator/multiplication1?a=900&b=26&user=Natalia```
    - ```localhost:8888/calculator/multiplication1?a=720&b=48&user=Juan```
- History Services
    -  ```localhost:8888/services/history```

5. Prueba base de datos (mediante navegador):
- Database
    - ``localhost:8888/h2-console``
- Access
    - JDBC URL: ``jdbc:h2:file:/data/demo``
    - User Name: ``services-db``
    - Password: [application.properties(calculator)]
