# 📦 SOAP CLIENT
Este proyecto es una pequeña practica, para realizar el consumo de un servicio SOAP, este servicio es el servicio de balance del back del siguiente proyecto: https://github.com/jaimebp07/API-NET-SOAP

## 🛠️ Tecnologías usadas
- Java 21
- Spring Boot 3.x

## Pasos para ejecutar el proyecto

1. Tener en ejecucion el proyecto del cual se va a consumir el servicio, el cual es un back desarrollado en .NET [Backend](https://github.com/jaimebp07/employees-angular-springboot)
2. Ejecutar el siguiente comando para generar las clases automaticamete desde el archivo WSDL, el cual deberia generar la carpeta target
```sh
mvn clean compile
```

### Tips
- Parece que es importante, al menos para vs code, abrir este proyecto en SOAPCLIENT/, no en la carpeta raiz del repositorio

## Estado del proyecto
En este punto del desarrollo del proyecto, al intentar consumir el servivio me esta devolviendo un error, debido a que el servicio soap que se esta intentando consumir desde este proyecto de spring boot no es realmente un servicio SOAP, aunque retorna un XML, esto no significa que sea un servicio SOAP