/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prestamobancario;
import java.util.Scanner;
/**
 *
 * @author jaiderreyes
 */
public class PrestamoBancario {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el monto del préstamo: ");
        double monto = sc.nextDouble();

        System.out.print("Ingrese la tasa de interés anual (%): ");
        double tasaAnual = sc.nextDouble();

        System.out.print("Ingrese la cantidad de años del préstamo: ");
        int años = sc.nextInt();

        double tasaMensual = (tasaAnual / 100) / 12;
        int numPagos = años * 12;

        // Fórmula del pago mensual
        double pagoMensual = (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -numPagos));

        System.out.printf("El pago mensual es: $%.2f\n", pagoMensual);
    }
}
