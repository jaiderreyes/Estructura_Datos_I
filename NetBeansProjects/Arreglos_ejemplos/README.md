# Arreglos con Clases y Objetos - Ejemplos para Estructura de Datos

Este proyecto NetBeans contiene ejemplos sencillos para enseñar arreglos utilizando clases y objetos en Java.

## 📁 Estructura del Proyecto

```
src/arreglos_ejemplos/
├── Estudiante.java          # Clase que representa un objeto Estudiante
├── ArreglosConObjetos.java  # Ejemplo básico con diferentes tipos de arreglos
└── GestionEstudiantes.java  # Aplicación completa con menú interactivo
```

## 🎯 Objetivos de Aprendizaje

1. **Crear y manipular arreglos de tipos primitivos**
2. **Trabajar con arreglos de objetos String**
3. **Crear arreglos de objetos personalizados**
4. **Implementar métodos para operar con arreglos**
5. **Utilizar arreglos bidimensionales**
6. **Desarrollar aplicaciones interactivas**

## 📋 Ejemplos Incluidos

### 1. ArreglosConObjetos.java
- Arreglo de enteros con recorridos for y for-each
- Arreglo de Strings
- Arreglo de objetos Estudiante
- Operaciones: suma, búsqueda del máximo
- Arreglo bidimensional (matriz 3x3)

### 2. GestionEstudiantes.java
- Sistema completo de gestión de estudiantes
- Menú interactivo con opciones:
  - Agregar estudiantes
  - Mostrar todos los estudiantes
  - Buscar por nombre
  - Calcular promedio general
- Manejo de arreglo con capacidad limitada

## 🚀 Cómo Ejecutar en NetBeans

1. **Abrir NetBeans IDE**
2. **File → Open Project** y seleccionar la carpeta del proyecto
3. **Botón derecho en el proyecto → Run**
4. Para cambiar la clase principal:
   - **Project Properties → Run → Main Class**
   - Seleccionar `arreglos_ejemplos.GestionEstudiantes`

## 💡 Conceptos Clave

### Clase Estudiante
```java
public class Estudiante {
    private String nombre;
    private int edad;
    private double promedio;
    
    // Constructor, getters, setters y toString()
}
```

### Declaración de Arreglos
```java
// Arreglo de primitivos
int[] numeros = new int[5];

// Arreglo de objetos
Estudiante[] estudiantes = new Estudiante[10];
String[] nombres = {"Ana", "Juan", "María"};

// Arreglo bidimensional
int[][] matriz = new int[3][3];
```

### Recorrido de Arreglos
```java
// For tradicional
for (int i = 0; i < estudiantes.length; i++) {
    System.out.println(estudiantes[i].getNombre());
}

// For-each
for (Estudiante est : estudiantes) {
    System.out.println(est.getNombre());
}
```

## 🎓 Ejercicios Propuestos

1. **Método para ordenar estudiantes por promedio**
2. **Contar estudiantes mayores de edad**
3. **Encontrar estudiante con mayor edad**
4. **Calcular promedio por rango de edad**
5. **Implementar búsqueda binaria**

## 🛠️ Requisitos

- Java Development Kit (JDK) 8 o superior
- Apache NetBeans IDE 12 o superior

## 📚 Temas Relacionados

- Programación Orientada a Objetos
- Estructuras de datos lineales
- Algoritmos de búsqueda y ordenamiento
- Manejo de excepciones

---

*Proyecto creado para la cátedra de Estructura de Datos I*