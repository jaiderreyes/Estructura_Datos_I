/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.batallapokemonsimple;

/**
 *
 * @author jaiderreyes
 */
import java.util.Scanner;
public class BatallaPokemonSimple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🏆 Datos del primer Pokémon
        System.out.print("Ingrese el nombre del primer Pokémon: ");
        String nombre1 = scanner.nextLine();
        
        System.out.print("Ingrese la vida de " + nombre1 + ": ");
        int vida1 = scanner.nextInt();
        
        System.out.print("Ingrese el ataque de " + nombre1 + ": ");
        double ataque1 = scanner.nextDouble();
        
        System.out.print("Ingrese la defensa de " + nombre1 + ": ");
        double defensa1 = scanner.nextDouble();
        
        System.out.print("¿Es tipo fuego? (true/false): ");
        boolean esFuego1 = scanner.nextBoolean();
        
        scanner.nextLine(); // Limpiar el buffer

        // 🏆 Datos del segundo Pokémon
        System.out.print("\nIngrese el nombre del segundo Pokémon: ");
        String nombre2 = scanner.nextLine();
        
        System.out.print("Ingrese la vida de " + nombre2 + ": ");
        int vida2 = scanner.nextInt();
        
        System.out.print("Ingrese el ataque de " + nombre2 + ": ");
        double ataque2 = scanner.nextDouble();
        
        System.out.print("Ingrese la defensa de " + nombre2 + ": ");
        double defensa2 = scanner.nextDouble();
        
        System.out.print("¿Es tipo fuego? (true/false): ");
        boolean esFuego2 = scanner.nextBoolean();

        System.out.println("\n🔥 ¡Comienza la batalla Pokémon! 🔥\n");

        // ⚔️ Un solo ataque de cada Pokémon
        double danio1 = ataque1 - defensa2;
        if (danio1 < 0) danio1 = 5; // Daño mínimo de 5
        if (esFuego1 && !esFuego2) danio1 *= 1.2; // Bonus de tipo fuego
        vida2 -= danio1;

        System.out.println(nombre1 + " ataca a " + nombre2 + " causando " + danio1 + " de daño.");

        double danio2 = ataque2 - defensa1;
        if (danio2 < 0) danio2 = 5;
        if (esFuego2 && !esFuego1) danio2 *= 1.2;
        vida1 -= danio2;

        System.out.println(nombre2 + " ataca a " + nombre1 + " causando " + danio2 + " de daño.");

        // 🏆 Determinar el ganador (sin bucles)
        System.out.println("\n--- RESULTADOS ---");
        if (vida1 > vida2) {
            System.out.println("🏅 " + nombre1 + " ha ganado la batalla con " + vida1 + " de vida restante.");
        } else if (vida2 > vida1) {
            System.out.println("🏅 " + nombre2 + " ha ganado la batalla con " + vida2 + " de vida restante.");
        } else {
            System.out.println("🤝 ¡Empate! Ambos Pokémon han quedado con la misma vida.");
        }
    }
}
