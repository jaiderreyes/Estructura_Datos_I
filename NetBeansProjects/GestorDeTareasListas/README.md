# GestorDeTareasListas

Proyecto de consola (Maven, compatible con NetBeans) para enseñar **Listas en Java** con un menú interactivo:
- CRUD de tareas con `ArrayList`
- Búsqueda, ordenamiento por prioridad/estado
- Persistencia simple en CSV

## Cómo ejecutar en NetBeans
1. Abrir NetBeans → *Open Project* → seleccionar carpeta `GestorDeTareasListas`.
2. Botón derecho sobre el proyecto → *Run*.

## Cómo ejecutar por terminal
```bash
mvn -q -f GestorDeTareasListas/pom.xml clean package
java -cp GestorDeTareasListas/target/GestorDeTareasListas-1.0-SNAPSHOT.jar edu.uajs.listas.Main
```

Opcional (plugin exec):
```bash
mvn -q -f GestorDeTareasListas/pom.xml exec:java
```
