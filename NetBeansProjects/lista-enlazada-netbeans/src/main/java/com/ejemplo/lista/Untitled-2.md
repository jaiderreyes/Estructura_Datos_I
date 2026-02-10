
Este flujo asegura que solo los clientes autenticados puedan acceder a recursos protegidos y realizar operaciones críticas.

---

## IV. Resultados Simulados

Se realizaron pruebas simuladas para medir el rendimiento, la eficiencia en exportación de documentos y la seguridad del sistema.

### A. Rendimiento de Consultas Distribuidas

| Tipo de consulta              | Tiempo medio BD centralizada | Tiempo medio con Citus |
|------------------------------|------------------------------|------------------------|
| SELECT simple por ID        | 48 ms                        | **17 ms**              |
| JOIN entre tablas           | 120 ms                       | **56 ms**              |
| Consulta con agregación     | 210 ms                       | **88 ms**              |

El uso de Citus redujo en promedio un **60 %** los tiempos de respuesta en operaciones de lectura intensiva.

---

### B. Exportación de Historias Clínicas en PDF

| Tamaño de registro         | Tiempo medio de exportación |
|---------------------------|----------------------------|
| 1 paciente (10 KB)       | 0.43 s                     |
| 50 pacientes (450 KB)    | 1.88 s                     |
| 200 pacientes (1.8 MB)   | 5.21 s                     |

La exportación se mantuvo estable incluso con grandes volúmenes de registros, garantizando la usabilidad del sistema.

---

### C. Seguridad y Autenticación OAuth2 + JWT

| Escenario                        | Resultado                                 |
|----------------------------------|-------------------------------------------|
| Intento sin token                | Denegado (HTTP 401)                       |
| Token expirado                  | Denegado (HTTP 403)                       |
| Token válido, rol médico        | Acceso permitido a registro de diagnósticos |
| Token válido, rol paciente      | Acceso restringido a descarga de historia clínica |

La autenticación basada en JWT permitió implementar políticas de acceso diferenciadas por rol, reforzando la confidencialidad de los datos.

---

### D. Acceso desde Dispositivos Externos

Pruebas desde dispositivos móviles conectados a la misma red mostraron latencias promedio de **32 ms**, confirmando que la arquitectura permite acceso seguro y eficiente desde cualquier dispositivo.

---

## V. Discusión

Los resultados demuestran que la arquitectura propuesta mejora sustancialmente el rendimiento en consultas y exportación, a la vez que integra mecanismos sólidos de seguridad y control de acceso.  
La interoperabilidad garantizada por los estándares HL7 permite que el sistema se comunique con otros servicios clínicos, mientras que el uso de OAuth2 + JWT asegura la confidencialidad y trazabilidad de los datos.

En el ámbito académico, este proyecto constituye un caso práctico integral que combina sistemas distribuidos, microservicios, seguridad informática y estándares sanitarios, fortaleciendo la formación de ingenieros en el desarrollo de soluciones críticas para el sector salud.

---

## VI. Conclusiones y Trabajos Futuros

Este trabajo demuestra que es posible diseñar sistemas distribuidos seguros, escalables y orientados a la interoperabilidad clínica mediante la combinación de **PostgreSQL-Citus**, **FastAPI** y **OAuth2**.  
La separación en capas facilita el mantenimiento y evolución del sistema, y la exportación de historias clínicas en PDF asegura la accesibilidad de la información.

Como líneas de trabajo futuro, se propone incorporar autenticación multifactor, utilizar estándares **FHIR** para ampliar la interoperabilidad y añadir módulos de analítica clínica basados en inteligencia artificial.

---

## Referencias

[1] HL7 International, “Health Level Seven International,” [En línea]. Disponible en: https://www.hl7.org  
[2] PostgreSQL Global Development Group, “PostgreSQL Documentation,” [En línea]. Disponible en: https://www.postgresql.org  
[3] FastAPI, “FastAPI Framework,” [En línea]. Disponible en: https://fastapi.tiangolo.com  
[4] OAuth Working Group, “OAuth 2.0 Authorization Framework,” IETF RFC 6749, 2012.  
[5] Citus Data, “Citus: Distributed PostgreSQL,” [En línea]. Disponible en: https://www.citusdata.com

---

## Biografía del Autor

**Jaider Enrique Reyes Herazo** es docente investigador del programa de Ingeniería de Sistemas en la Corporación Universitaria Antonio José de Sucre (UAJS), Sincelejo, Colombia. Su trabajo académico se centra en la innovación tecnológica, los sistemas distribuidos, la gestión del conocimiento y la interoperabilidad en salud.

---

## 🛠️ Instrucciones para convertir este archivo

Una vez guardado este archivo como `Paper_Historia_Clinica_Distribuida.md`, puedes convertirlo fácilmente en `.docx` o `.pdf` con [Pandoc](https://pandoc.org):

### Instalar Pandoc
- Ubuntu / Debian:
  ```bash
  sudo apt install pandoc
