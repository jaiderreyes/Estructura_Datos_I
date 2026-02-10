
package com.taller.arreglos;
import java.util.Arrays;
import java.util.Comparator;
public class OrdenarEstudiantesComp {
    public static void run() {
        Estudiante[] v = {
            new Estudiante("Ana",4.2),
            new Estudiante("Luis",3.8),
            new Estudiante("Zoe",4.2),
            new Estudiante("Juan",2.9)
        };
        Arrays.sort(v, Comparator
            .comparingDouble((Estudiante e) -> e.nota).reversed()
            .thenComparing(e -> e.nombre));
        System.out.println(Arrays.toString(v));
    }
}
