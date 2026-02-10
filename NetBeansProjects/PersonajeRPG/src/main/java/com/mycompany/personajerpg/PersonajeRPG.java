/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.personajerpg;


/**
 *
 * @author jaiderreyes
 */
import java.util.Scanner;

public class PersonajeRPG {

    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);

        // 🏷️ Pedimos al usuario que ingrese los atributos del personaje
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nivel del personaje: ");
        int nivel = scanner.nextInt();

        System.out.print("Ingrese los puntos de vida (HP): ");
        int vida = scanner.nextInt();

        System.out.print("Ingrese la velocidad del personaje: ");
        double velocidad = scanner.nextDouble();

        System.out.print("¿Tiene superpoderes? (true/false): ");
        boolean tieneSuperpoderes = scanner.nextBoolean();

        System.out.print("Elija el tipo de guerrero (M: Mago, G: Guerrero, A: Arquero): ");
        char tipoGuerrero = scanner.next().charAt(0);
        

        // 🎮 Mostramos la ficha del personaje
        System.out.println("\n--- PERSONAJE CREADO ---");
        System.out.println("🧙‍♂️ Nombre: " + nombre);
        System.out.println("⚡ Nivel: " + nivel);
        System.out.println("❤️ Vida: " + vida);
        System.out.println("🏃 Velocidad: " + velocidad);
        System.out.println("✨ ¿Tiene superpoderes? " + (tieneSuperpoderes ? "Sí" : "No"));
        System.out.println("⚔️ Tipo de guerrero: " + tipoGuerrero);

        
    //    if (tieneSuperpoderes = "True") {
         //       System.out.println("🔮 Eres un mago poderoso que lanza hechizos.");
    
        //}
    
        // 🏆 Bonus: Cambia el mensaje según el tipo de guerrero
        switch (tipoGuerrero) {
            case 'M':
                System.out.println("🔮 Eres un mago poderoso que lanza hechizos.");
                break;
            case 'G':
                System.out.println("🛡️ Eres un guerrero con espada y armadura.");
                break;
            case 'A':
                System.out.println("🏹 Eres un arquero ágil con gran puntería.");
                break;
            default:
                System.out.println("❓ Tipo de guerrero desconocido.");
        }
    }
}
