/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.menudowhile;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class MenuDoWhile {

    public static void main(String[] args) {
       
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1");
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
        
    }
}
