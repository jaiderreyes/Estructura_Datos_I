/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.coche;

/**
 *
 * @author jaiderreyes
 */
public class Coche {

    // Atributos (propiedades)
    String marca;
    String modelo;
    int año;
 // Constructor
    public Coche(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public void arrancar() {
        System.out.println("El " + marca + " " + modelo + " está arrancando.");
    }

    public void detener() {
        System.out.println("El " + marca + " " + modelo + " se ha detenido.");
    
    }
    
    
    
    public static void main(String[] args) {
      // Creación de un objeto utilizando el constructor
        Coche miCoche = new Coche("Toyota", "fortuner", 2024);
      Coche miCoche2 = new Coche("Toyota", "prado", 2025);
        
        // Usar métodos del objeto
        miCoche.arrancar();
        miCoche.detener();
        
       //
       
           miCoche2.arrancar();
        miCoche2.detener();
        
    }
}
