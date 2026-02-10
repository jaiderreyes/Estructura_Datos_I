/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarifataxi;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class TarifaTaxi {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el tipo de servicio:");
        System.out.println("1. Regular");
        System.out.println("2. Ejecutivo");
        System.out.println("3. Lujo");
        System.out.print("Ingrese su opción: ");
        int opcion = sc.nextInt();

        System.out.print("Ingrese la distancia en km: ");
        double distancia = sc.nextDouble();

        double tarifa = 0;

        switch (opcion) {
            case 1:
                tarifa = 2.5;
                break;
            case 2:
                tarifa = 4.0;
                break;
            case 3:
                tarifa = 6.0;
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        double costoTotal = distancia * tarifa;
        System.out.println("El costo total del viaje es: $" + costoTotal);
    }
}
