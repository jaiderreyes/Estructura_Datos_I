# AgendaLinkedHashMap

Proyecto **sencillo** para enseñar `LinkedHashMap` en Java (consola, Maven, compatible con NetBeans).

## Qué muestra
- Inserción, consulta, actualización y eliminación (`put`, `get`, `replace`, `remove`).
- Recorrido en **orden de inserción**.
- Demostración simple de **priorizar elementos consultados** al listar.
- Diferencias prácticas con `HashMap`: orden estable de iteración.

## Abrir en NetBeans
1. Descomprime el zip.
2. NetBeans → *Open Project* → selecciona `AgendaLinkedHashMap`.
3. **Run** (F6).

## Terminal (opcional)
```bash
mvn -q -f AgendaLinkedHashMap/pom.xml clean package
java -cp AgendaLinkedHashMap/target/AgendaLinkedHashMap-1.0-SNAPSHOT.jar edu.uajs.mapas.Main
```
o
```bash
mvn -q -f AgendaLinkedHashMap/pom.xml exec:java
```
