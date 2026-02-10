
package com.taller.arreglos;
public class BuscarEstudiante {
    public static int findByNombre(Estudiante[] v, String nombre){
        for(int i=0;i<v.length;i++) if (v[i].nombre.equalsIgnoreCase(nombre)) return i;
        return -1;
    }
    public static void run() {
        Estudiante[] v = {
            new Estudiante("Ana",4.2),
            new Estudiante("Luis",3.8),
            new Estudiante("Zoe",4.2)
        };
        int pos = findByNombre(v, "luis");
        System.out.println("luis en índice: " + pos);
    }
}
