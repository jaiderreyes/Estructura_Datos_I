# Bubble Sort Project

## Descripción del Proyecto

Proyecto Maven Java que implementa el algoritmo de ordenamiento Bubble Sort (ordenamiento de burbuja) como demostración práctica de estructuras de datos y algoritmos.

## Estructura del Proyecto

```
Bublesort/
├── pom.xml                           # Configuración Maven
├── src/
│   └── main/
│       └── java/
│           └── com/mycompany/bublesort/
│               └── Bublesort.java    # Clase principal
└── target/                           # Directorio de compilación
```

### Configuración Técnica

- **Tipo**: Proyecto Maven Java
- **Versión Java**: 20
- **GroupId**: com.mycompany
- **ArtifactId**: Bublesort
- **Versión**: 1.0-SNAPSHOT
- **Paquete**: `com.mycompany.bublesort`
- **Clase principal**: `com.mycompany.bublesort.Bublesort`

## Lógica de Programación

### Algoritmo Bubble Sort Implementado

El proyecto implementa el algoritmo Bubble Sort clásico en `Bublesort.java:16-25`:

```java
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
            // Intercambio
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

### Funcionamiento del Algoritmo

1. **Comparación**: Compara elementos adyacentes del array
2. **Intercambio**: Si el elemento izquierdo es mayor que el derecho, los intercambia
3. **Repetición**: Repite el proceso hasta que todo el array esté ordenado
4. **Salida**: Imprime el array ordenado en consola

### Datos de Prueba

- **Array de entrada**: `{4, 2, 1, 3}`
- **Salida esperada**: `1 2 3 4`

## Complejidad Temporal

| Caso | Complejidad | Descripción |
|------|-------------|-------------|
| Peor caso | O(n²) | Array en orden descendente completo |
| Caso promedio | O(n²) | Array desordenado aleatoriamente |
| Mejor caso (actual) | O(n²) | Array ya ordenado (ineficiente) |

## Optimizaciones Identificadas

### Problemas de Rendimiento Actuales

1. **Ineficiencia en mejor caso**: Continúa procesando aunque el array ya esté ordenado
2. **Redundancia en bucle interno**: No limita las comparaciones en pasadas sucesivas
3. **Complejidad constante**: Siempre O(n²), sin optimización para casos favorables

### Optimizaciones Recomendadas

#### 1. Optimización con Bandera

```java
for (int i = 0; i < arr.length - 1; i++) {
    boolean swapped = false;
    for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
            // Intercambio
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            swapped = true;
        }
    }
    if (!swapped) break; // Salir temprano si no hubo intercambios
}
```

**Beneficios**:
- **Mejor caso optimizado**: O(n) si el array ya está ordenado
- **Detección temprana**: Termina cuando no hay más intercambios

#### 2. Optimización de Límite del Bucle Interno

```java
for (int j = 0; j < arr.length - 1 - i; j++) // Limitar comparaciones
```

**Beneficios**:
- Reduce comparaciones innecesarias
- Los elementos más grandes ya están en su posición final

## Compilación y Ejecución

### Prerrequisitos
- JDK 20 o superior
- Apache Maven 3.6+

### Comandos

```bash
# Compilar el proyecto
mvn compile

# Ejecutar el programa
mvn exec:java -Dexec.mainClass="com.mycompany.bublesort.Bublesort"

# Limpiar y compilar
mvn clean compile
```

## Características Actuales

### Funcionalidades
- ✅ Implementación básica de Bubble Sort
- ✅ Salida en consola del array ordenado
- ✅ Configuración Maven completa

### Limitaciones
- ❌ Sin entrada de datos por usuario
- ❌ Sin validación de entrada
- ❌ Sin manejo de diferentes tipos de datos
- ❌ Sin interfaz gráfica
- ❌ Sin pruebas unitarias
- ❌ Sin optimizaciones de rendimiento

## Mejoras Futuras Sugeridas

### Mejoras de Rendimiento
1. Implementar optimización con bandera
2. Limitar bucle interno en cada pasada
3. Considerar algoritmos más eficientes para arrays grandes

### Mejoras de Funcionalidad
1. Entrada de datos por usuario o archivo
2. Soporte para diferentes tipos de datos (String, double, etc.)
3. Manejo de arrays vacíos o nulos
4. Medición de tiempo de ejecución
5. Comparación con otros algoritmos de ordenamiento

### Mejoras de Calidad de Código
1. Añadir pruebas unitarias con JUnit
2. Implementar logging en lugar de System.out.println
3. Separar lógica de entrada/salida
4. Añadir documentación JavaDoc
5. Manejo de excepciones

## Contexto Académico

Este proyecto es parte del curso **Estructura de Datos I**, diseñado para:
- Comprender algoritmos de ordenamiento básicos
- Analizar complejidad temporal y espacial
- Practicar implementación en Java
- Identificar oportunidades de optimización

## Autor

- **Nombre**: jaiderreyes
- **Asignatura**: Estructura de Datos I
- **Institución**: U.A.J.S.