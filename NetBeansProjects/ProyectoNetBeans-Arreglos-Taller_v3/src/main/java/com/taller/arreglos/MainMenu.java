
package com.taller.arreglos;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Taller Arreglos (Java) ===");
            System.out.println("1) Termómetro de aula");
            System.out.println("2) Top 3 playlists");
            System.out.println("3) Votación rápida en clase");
            System.out.println("4) Cine mini (fila de 10)");
            System.out.println("5) Kiosko escolar");
            System.out.println("6) Marcador deportivo");
            System.out.println("7) Bingo simple");
            System.out.println("8) Matriz de calificaciones");
            System.out.println("9) Radar de emojis");
            System.out.println("10) Mini-ordenamiento visual");
            System.out.println("11) Módulo 2: Matrices, ordenamiento y objetos");
            System.out.println("0) Salir");
            System.out.print("Seleccione opción: ");
            String op = sc.nextLine().trim();
            switch (op) {
                case "1": Ej1Termometro.run(); break;
                case "2": Ej2TopPlaylists.run(); break;
                case "3": Ej3Votacion.run(); break;
                case "4": Ej4Cine.run(); break;
                case "5": Ej5Kiosko.run(); break;
                case "6": Ej6Marcador.run(); break;
                case "7": Ej7Bingo.run(); break;
                case "8": Ej8Matriz.run(); break;
                case "9": Ej9Emojis.run(); break;
                case "10": Ej10Ordenamiento.run(); break;
                case "11": SubMenuModulo2.run(); break;
                case "0": System.out.println("Fin."); return;
                default: System.out.println("Opción inválida.");
            }
        }
    }
}
