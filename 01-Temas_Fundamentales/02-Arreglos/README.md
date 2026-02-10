# 📊 Arreglos - Ejemplos y Proyectos

Esta sección contiene ejemplos prácticos y proyectos completos que demuestran el uso de arreglos en Java.

## 📁 **Estructura de Contenidos**

```
📦 02-Arreglos/
├── 📂 01-Ejemplos_Basicos/
│   ├── 📄 ArregloEnteros.java
│   ├── 📄 ArregloStrings.java
│   └── 📄 ArregloObjetos.java
├── 📂 02-Ejercicios_Practicos/
│   ├── 📄 Ejercicio1_SumaElementos.java
│   ├── 📄 Ejercicio2_BusquedaMaximo.java
│   └── 📄 Ejercicio3_OrdenamientoBurbuja.java
└── 📂 03-Proyectos_Completos/
    └── 📂 Arreglos_ejemplos/
        ├── 📄 Estudiante.java
        ├── 📄 ArreglosConObjetos.java
        ├── 📄 GestionEstudiantes.java
        └── 📄 README.md
```

## 🎯 **Objetivos de Aprendizaje**

Al completar esta sección, los estudiantes podrán:

1. ✅ **Declarar y crear** arreglos de diferentes tipos
2. ✅ **Manipular** elementos individuales de un arreglo
3. ✅ **Recorrer** arreglos usando diferentes bucles
4. ✅ **Implementar** algoritmos básicos con arreglos
5. ✅ **Crear** arreglos de objetos personalizados
6. ✅ **Desarrollar** aplicaciones completas usando arreglos

## 🚀 **Proyecto Principal: Gestión de Estudiantes**

### 📋 **Descripción**
Sistema completo para gestionar información de estudiantes utilizando arreglos como estructura de datos principal.

### 🛠️ **Características Técnicas**
- **Lenguaje**: Java 8+
- **IDE**: NetBeans 12+
- **Estructura**: Arreglos de objetos
- **Entrada/Salida**: Consola con Scanner

### 📊 **Componentes del Sistema**

#### 🏗️ **Clase Estudiante**
```java
public class Estudiante {
    private String nombre;
    private int edad;
    private double promedio;
    
    // Constructor, getters, setters y toString()
}
```

#### 📋 **Clase ArreglosConObjetos**
- Ejemplos básicos de diferentes tipos de arreglos
- Demostración de patrones de programación
- Operaciones comunes con arreglos

#### 🎛️ **Clase GestionEstudiantes**
- Sistema interactivo con menú principal
- CRUD completo de estudiantes
- Búsqueda y cálculo de estadísticas

### 📖 **Conceptos Clave**

#### 📊 **Declaración de Arreglos**
```java
// Arreglo de primitivos
int[] numeros = new int[5];

// Arreglo de objetos
Estudiante[] estudiantes = new Estudiante[10];

// Inicialización directa
String[] nombres = {"Ana", "Juan", "María"};
```

#### 🔄 **Recorrido de Arreglos**
```java
// For tradicional
for (int i = 0; i < arreglo.length; i++) {
    System.out.println(arreglo[i]);
}

// For-each
for (Tipo elemento : arreglo) {
    System.out.println(elemento);
}
```

#### 🎯 **Patrones de Programación**
- **Acumulación**: Sumar elementos de un arreglo
- **Búsqueda**: Encontrar el elemento máximo/mínimo
- **Filtrado**: Seleccionar elementos que cumplen condición
- **Transformación**: Modificar todos los elementos

## 📚 **Ejemplos Prácticos**

### 1️⃣ **Arreglo de Enteros**
- Creación y asignación de valores
- Recorrido con diferentes bucles
- Operaciones matemáticas básicas

### 2️⃣ **Arreglo de Strings**
- Manipulación de cadenas
- Búsqueda de patrones
- Ordenamiento alfabético

### 3️⃣ **Arreglo de Objetos**
- Creación de objetos personalizados
- Acceso a atributos y métodos
- Relación entre objetos

### 4️⃣ **Arreglo Bidimensional**
- Matrices y tablas
- Recorrido anidado
- Aplicaciones matemáticas

## 🎓 **Ejercicios Propuestos**

### 🟢 **Nivel Básico**
1. Calcular la suma de todos los elementos
2. Encontrar el elemento mayor y menor
3. Contar elementos que cumplen una condición
4. Invertir el orden de un arreglo

### 🟡 **Nivel Intermedio**
1. Implementar búsqueda binaria
2. Crear método para ordenar arreglos
3. Eliminar elementos duplicados
4. Combinar dos arreglos en uno solo

### 🔴 **Nivel Avanzado**
1. Crear arreglo dinámico (redimensionable)
2. Implementar estructura de pila con arreglos
3. Desarrollar sistema de gestión completo
4. Optimizar algoritmos para grandes volúmenes

## 🛠️ **Cómo Ejecutar los Proyectos**

### **Requisitos Previos**
- JDK 8 o superior instalado
- NetBeans IDE 12 o superior
- Conocimientos básicos de Java

### **Pasos para Ejecutar**
1. **Abrir NetBeans IDE**
2. **File → Open Project**
3. **Seleccionar** la carpeta del proyecto
4. **Botón derecho → Run**
5. **Seguir** las instrucciones en consola

### **Configuración del Proyecto**
- **Clase Principal**: `arreglos_ejemplos.ArreglosConObjetos`
- **Versión Java**: 1.8+
- **Dependencias**: Ninguna (Java estándar)

## 📊 **Métricas y Complejidad**

| Operación | Complejidad | Descripción |
|-----------|-------------|-------------|
| Acceso directo | O(1) | Acceso por índice |
| Búsqueda lineal | O(n) | Recorrer todo el arreglo |
| Inserción | O(n) | Desplazar elementos |
| Eliminación | O(n) | Desplazar elementos |
| Ordenamiento | O(n²) | Burbuja, selección |

## 🎯 **Mejores Prácticas**

### ✅ **Recomendaciones**
- Validar límites del arreglo
- Usar for-each cuando no se necesita el índice
- Documentar métodos con JavaDoc
- Manejar excepciones apropiadamente

### ❌ **Errores Comunes**
- ArrayIndexOutOfBoundsException
- NullPointerException en arreglos de objetos
- No inicializar arreglos de objetos
- Confundir tamaño con capacidad

## 🔄 **Próximos Temas**

Después de dominar los arreglos, exploraremos:

1. 🔗 **Listas Enlazadas** - Estructuras dinámicas
2. 📚 **Pilas** - LIFO y aplicaciones
3. 🎫 **Colas** - FIFO y variantes
4. 🌳 **Árboles** - Estructuras jerárquicas

---

📚 **Continúa practicando y experimentando con diferentes tipos de arreglos para solidificar tus conocimientos!**