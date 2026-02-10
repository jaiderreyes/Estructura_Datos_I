/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persona;
//import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class Persona{
    //atributos (propiedades)
    
    string nombre;
    int edad; 
   // char  sexo; 
    
    // contructor
    
    public Persona (string nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
       // this.sexo = sexo;
       
       
       
        
    }
    
    public void presentarse(){
          System.out.println("Hola, me llamo " + nombre + ", tengo " + edad + " años y soy colombiana ");
    }

    
    // Getters y Setters (opcional)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

    
    
  public static void main(String[] args) {
        
     
        Persona persona1 = new Persona(( "hola", 233 );
      
        persona1.presentarse(); // Salida: Hola, me llamo Juan, tengo 25 años y soy masculino.
      //  persona2.presentarse();
    
                
    }
}
