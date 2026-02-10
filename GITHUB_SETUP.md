# 🚀 Guía para Subir el Repositorio a GitHub

## 📋 **Paso a Paso - Subir tu Repositorio**

### 1️⃣ **Crear Repositorio en GitHub**

1. **Iniciar sesión** en [GitHub](https://github.com/)
2. **Crear nuevo repositorio**:
   - Hacer clic en `+` → `New repository`
   - **Nombre**: `Estructura_Datos_I`
   - **Descripción**: "Curso completo de Estructura de Datos I con Java y NetBeans"
   - **Visibilidad**: Public (o Private si prefieres)
   - **NO** marcar "Add a README file" (ya tenemos uno)
   - **NO** marcar "Add .gitignore" (ya configuramos uno)
3. **Hacer clic** en `Create repository`

### 2️⃣ **Conectar Local con Remoto**

Abre la terminal en tu directorio del proyecto:

```bash
# Verificar que estás en el directorio correcto
pwd
# Debe mostrar: /Users/jaiderreyes/Library/CloudStorage/GoogleDrive-coordinacion_emprendimiento@uajs.edu.co/Mi unidad/2026/Asignaturas/Estructura_datos_I_AA

# Configurar Git (si no lo has hecho antes)
git config --global user.name "jaiderreyes"
git config --global user.email "jaider.reyes@gmail.com"

# Agregar el remoto (reemplaza TU_USERNAME con tu usuario de GitHub)
git remote add origin https://github.com/jaiderreyes/Estructura_Datos_I.git

# Verificar el remoto configurado
git remote -v
```

### 3️⃣ **Subir el Repositorio**

```bash
# Cambiar el nombre de la rama main a main (si está en master)
git branch -M main

# Subir al repositorio remoto
git push -u origin main
```

### 4️⃣ **Verificar en GitHub**

1. **Visita** tu repositorio: `https://github.com/TU_USERNAME/Estructura_Datos_I`
2. **Verifica** que todos los archivos estén ahí
3. **Confirma** que el README se muestre correctamente

## 🛠️ **Comandos Git Esenciales**

### **Para el Flujo Diario**

```bash
# Ver estado del repositorio
git status

# Agregar cambios específicos
git add archivo.java

# Agregar todos los cambios
git add .

# Crear un commit
git commit -m "feat: agregar nuevo ejemplo de arreglos"

# Subir cambios a GitHub
git push

# Actualizar desde GitHub
git pull
```

### **Para el Manejo de Ramas**

```bash
# Ver ramas existentes
git branch

# Crear nueva rama
git checkout -b feature/nueva-estructura

# Cambiar de rama
git checkout main

# Fusionar rama
git merge feature/nueva-estructura
```

## 📝 **Convención de Commits**

Usa estos prefijos en tus mensajes de commit:

- `feat:` Nueva funcionalidad
- `fix:` Corrección de errores
- `docs:` Cambios en documentación
- `style:` Formateo de código (sin cambios funcionales)
- `refactor:` Refactorización de código
- `test:` Agregar o modificar tests
- `chore:` Cambios de configuración

**Ejemplos:**
```bash
git commit -m "feat: agregar implementación de lista enlazada simple"
git commit -m "fix: corregir error en búsqueda binaria"
git commit -m "docs: actualizar README del módulo de pilas"
```

## 🔄 **Flujo de Trabajo Recomendado**

### **1. Para Nuevo Tema**
```bash
# Crear rama para el nuevo tema
git checkout -b topic/listas-enlazadas

# Trabajar en los archivos
# ... crear clases, documentación, ejemplos ...

# Guardar cambios
git add .
git commit -m "feat: implementar lista enlazada simple con documentación"

# Subir rama
git push origin topic/listas-enlazadas

# Crear Pull Request en GitHub
# (hacer merge con main cuando esté listo)
```

### **2. Para Correcciones**
```bash
# Estar en la rama main
git checkout main
git pull origin main

# Crear rama de corrección
git checkout -b fix/corregir-busqueda-binaria

# Hacer correcciones
git add .
git commit -m "fix: corregir índices en búsqueda binaria"

# Subir y crear Pull Request
git push origin fix/corregir-busqueda-binaria
```

## 🎯 **Próximos Pasos para el Curso**

### **Contenido a Agregar:**

1. **📚 Tema: Listas Enlazadas**
   ```bash
   git checkout -b topic/listas-enlazadas
   # Agregar ejemplos en: 02-Estructuras_Lineales/01-Listas_Enlazadas/
   ```

2. **📚 Tema: Pilas**
   ```bash
   git checkout -b topic/pilas
   # Agregar ejemplos en: 02-Estructuras_Lineales/02-Pilas/
   ```

3. **📚 Tema: Colas**
   ```bash
   git checkout -b topic/colas
   # Agregar ejemplos en: 02-Estructuras_Lineales/03-Colas/
   ```

### **Recomendaciones de Organización:**

- **Un tema = una rama**
- **Documentar cada módulo** con su propio README
- **Mantener consistencia** en la estructura de carpetas
- **Agregar ejemplos progresivos** (básico → intermedio → avanzado)

## 📞 **Soporte**

Si tienes problemas durante el proceso:

1. **Verifica la URL** del remoto: `git remote -v`
2. **Confirma tu conexión** a internet
3. **Verifica tus credenciales** de GitHub
4. **Usa `git status`** para diagnosticar problemas

---

🎉 **¡Felicidades! Ya tienes tu repositorio estructurado y listo para subir a GitHub.**

📧 **Para ayuda adicional**: Jaider.reyes@gmail.com