\# Sistema de Gestión Hospitalaria y Agendamiento Médico (MediConnect)

\### Proyecto Semestral - Experiencia de Aprendizaje 2

\* \*\*Asignatura:\*\* Desarrollo FullStack 1 (DSY1103)

\* \*\*Institución:\*\* Duoc UC

\* \*\*Integrantes:\*\* Ignacio Adolfo Zuñiga Danceanu



\---



\## 1. Descripción del Dominio y Contexto

Este proyecto consiste en una solución distribuida basada en un dominio real de salud para optimizar la gestión de pacientes, la administración del cuerpo médico y el agendamiento automatizado de consultas. La arquitectura está diseñada sobre un ecosistema de microservicios independientes, garantizando alta disponibilidad, escalabilidad, cohesión y separación funcional de responsabilidades.



\---



\## 2. Arquitectura de Software y Patrón de Diseño

Cada microservicio de la solución implementa estrictamente el patrón de diseño \*\*CSR (Controller-Service-Repository)\*\*, asegurando un flujo de datos ordenado y sin acoplamiento de responsabilidades:



\* \*\*Capa Controller:\*\* Orquesta y expone los endpoints de la API REST, gestiona las solicitudes HTTP entrantes y retorna respuestas estructuradas en formato JSON a través de objetos `ResponseEntity`.

\* \*\*Capa Service:\*\* Centraliza toda la lógica de negocio del dominio hospitalario, aplicando flujos de decisión, control transaccional mediante bloques `try/catch` y validaciones cruzadas.

\* \*\*Capa Repository/Model:\*\* Gestiona el acceso y la persistencia real de datos mediante el mapeo de entidades relacionales hacia el motor de base de datos.



\---



\## 3. Requisitos Técnicos Obligatorios Implementados



\### A. Persistencia Real con JPA + Hibernate

\* Implementación de entidades con anotaciones completas (`@Entity`, `@Id`, `@GeneratedValue`, `@Column`).

\* Uso interfaces que extienden de `JpaRepository` para la ejecución automática de operaciones CRUD completas y mapeo relacional.

\* Configuración dinámica de orígenes de datos (`datasource`) y dialectosSQL en el archivo `application.properties`.



\### B. Validaciones Robustas (Bean Validation - JSR 380)

\* Separación estricta entre \*\*Entidades\*\* de persistencia y \*\*DTOs (Data Transfer Objects)\*\* para la entrada limpia y segura de datos desde el cliente.

\* Uso de restricciones mediante anotaciones en la capa DTO (`@NotBlank`, `@Size`, `@Email`) para asegurar la integridad referencial antes de procesar las solicitudes.



\### C. Manejo Centralizado de Excepciones y Respuestas

\* Implementación de un componente global `@ControllerAdvice` (`GlobalExceptionHandler`) encargado de interceptar errores de validación y de negocio en tiempo de ejecución.

\* Retorno estructurado de mensajes informativos en formato JSON acompañados de los códigos HTTP correspondientes (`201 Created`, `200 OK`, `400 Bad Request`, `404 Not Found`).



\### D. Trazabilidad con Logs Estructurados

\* Integración de mensajería y trazabilidad de eventos clave en las capas críticas utilizando la herramienta de logs `SLF4J`.

\* Registro en consola de flujos exitosos (creación, actualización) y advertencias de validaciones fallidas para facilitar el mantenimiento y debugging.



\---



\## 4. Estructura del Ecosistema (Módulos Base)



1\.  \*\*ms-paciente (Puerto 8081):\*\* Encargado de la gestión y persistencia del registro civil de pacientes hospitalarios.

2\.  \*\*ms-medico (Puerto 8081 - Módulo Unificado):\*\* Encargado de administrar el staff médico y el control de especialidades.

3\.  \*\*ms-reserva (Módulo Orquestador):\*\* Puente lógico encargado de interceptar las solicitudes de agendamiento de horas y validar de manera cruzada la existencia de registros médicos y de usuarios.



\---



\## 5. Instrucciones para la Ejecución del Proyecto



\### Pre-requisitos

\* Java Development Kit (JDK) 17 instalado.

\* Motor de Base de Datos MySQL activo.

\* Herramienta Postman para pruebas de integración REST.



\### Despliegue del Entorno

1\.  Clonar este repositorio en su estación de trabajo local.

2\.  Importar el archivo SQL ubicado en la carpeta `base-de-datos/` para inicializar el esquema relacional del hospital.

3\.  Configurar las credenciales de acceso a su servidor MySQL local dentro del archivo `src/main/resources/application.properties`.

4\.  Abrir una terminal en la raíz de cada microservicio y ejecutar el comando oficial de Maven para compilar y levantar el servidor:

&#x20;   ```cmd

&#x20;   .\\mvnw.cmd clean spring-boot:run

&#x20;   ```

5\.  El microservicio estará escuchando peticiones en el puerto `8081` a través de la ruta base `/api/v1/`.

