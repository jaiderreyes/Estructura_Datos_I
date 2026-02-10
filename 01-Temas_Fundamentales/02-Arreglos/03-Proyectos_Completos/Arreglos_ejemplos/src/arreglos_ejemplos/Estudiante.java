package arreglos_ejemplos;

/**
 * Clase que representa un objeto Estudiante.
 * 
 * Esta clase sirve como modelo de datos para almacenar información básica
 * de un estudiante y será utilizada en los ejemplos de arreglos de objetos.
 * 
 * @author Profesor Jaider Reyes Herazo
 * @version 1.0
 * @since 2026
 */
public class Estudiante {
    /**
     * Nombre completo del estudiante.
     * Es un atributo privado para mantener el encapsulamiento.
     */
    private String nombre;
    
    /**
     * Edad del estudiante en años.
     * Almacenada como un entero positivo.
     */
    private int edad;
    
    /**
     * Promedio académico del estudiante.
     * Valor decimal entre 0.0 y 100.0 (o 0.0 y 5.0 según escala).
     */
    private double promedio;
    
    /**
     * Constructor de la clase Estudiante.
     * 
     * Inicializa una nueva instancia de Estudiante con los valores proporcionados.
     * Utiliza la palabra clave 'this' para diferenciar entre parámetros y atributos.
     * 
     * @param nombre Nombre completo del estudiante. No puede ser nulo o vacío.
     * @param edad Edad del estudiante en años. Debe ser un número positivo.
     * @param promedio Promedio académico del estudiante. Debe estar en el rango válido.
     */
    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }
    
    /**
     * Obtiene el nombre del estudiante.
     * 
     * Método getter para acceder al atributo privado nombre.
     * 
     * @return El nombre completo del estudiante.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del estudiante.
     * 
     * Método setter para modificar el atributo privado nombre.
     * 
     * @param nombre Nuevo nombre completo del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la edad del estudiante.
     * 
     * Método getter para acceder al atributo privado edad.
     * 
     * @return La edad del estudiante en años.
     */
    public int getEdad() {
        return edad;
    }
    
    /**
     * Establece la edad del estudiante.
     * 
     * Método setter para modificar el atributo privado edad.
     * 
     * @param edad Nueva edad del estudiante en años.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**
     * Obtiene el promedio del estudiante.
     * 
     * Método getter para acceder al atributo privado promedio.
     * 
     * @return El promedio académico del estudiante.
     */
    public double getPromedio() {
        return promedio;
    }
    
    /**
     * Establece el promedio del estudiante.
     * 
     * Método setter para modificar el atributo privado promedio.
     * 
     * @param promedio Nuevo promedio académico del estudiante.
     */
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    /**
     * Devuelve una representación en cadena del objeto Estudiante.
     * 
     * Sobrescribe el método toString() de la clase Object para proporcionar
     * una representación legible de los datos del estudiante.
     * 
     * @return Cadena con el formato: Estudiante{nombre=..., edad=..., promedio=...}
     */
    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", edad=" + edad + ", promedio=" + promedio + '}';
    }
}