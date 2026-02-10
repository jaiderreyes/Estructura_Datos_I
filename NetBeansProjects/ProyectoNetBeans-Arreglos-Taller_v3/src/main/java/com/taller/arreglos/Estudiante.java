
package com.taller.arreglos;
public class Estudiante implements Comparable<Estudiante> {
    String nombre; double nota;
    Estudiante(String n, double no){ nombre=n; nota=no; }
    @Override public int compareTo(Estudiante o){ return Double.compare(this.nota, o.nota); }
    @Override public String toString(){ return nombre + "(" + nota + ")"; }
}
