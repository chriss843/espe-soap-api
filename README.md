# UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE 
## Ingeniería en Tecnologías de la Información
### Integrantes:
Cristian Jácome 
            
Ruth Changalombo

### Correo: 

chrissjacome@gmail.com

### GitHub: 

chriss843

# Tracking SOAP API - Envíos Express S.A.C.
Este proyecto implementa una API SOAP utilizando **Spring Boot**, **Apache CXF** y **PostgreSQL**, 
simulando una solución para la empresa de logística ficticia **Envíos Express S.A.C.**
Permite a los clientes consultar el estado de sus paquetes utilizando un número único de tracking.
---

## ✅ Funcionalidades

- Consultar el **estado actual** del paquete
- Ver la **ubicación actual**
---
## Tecnologías utilizadas

- Java 17
- Spring Boot
- Apache CXF (SOAP)
- PostgreSQL
- Spring Data JPA (Hibernate)
- JAXB (para modelado XML)
---

## Despliegue local

### 1. Clonar el repositoriobash
git clone https://github.com/chriss843/espe-soap-api.git

cd espe-soap-api

### 2. Crear la base de datos
CREATE DATABASE bd-envios-express;

### 3. Ejecutar el pryecto desde el IDE o terminal
./mvnw spring-boot:run

### 4. Endpoints SOAP disponibles:

http://localhost:8080/services/TrackingService?wsdl

http://localhost:8080/services/PackageExpressService?wsdl