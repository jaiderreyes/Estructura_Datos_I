/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listaejemplo;
import java.util.ArrayList;
/**
 *
 * @author jaiderreyes
 */
public class ListaEjemplo {

    public static void main(String[] args) {
        // Crear una lista de tipo String
        ArrayList<String> frutas = new ArrayList<>();

        // Agregar elementos
        frutas.add("Manzana");
        frutas.add("Banano");
        frutas.add("Uva");

        // Mostrar elementos
        System.out.println("Lista de frutas: " + frutas);

        // Acceder a un elemento
        System.out.println("Primera fruta: " + frutas.get(0));

        // Eliminar un elemento
        frutas.remove("Banano");
        System.out.println("Lista después de eliminar: " + frutas);

        // Recorrer la lista con un for-each
        System.out.println("Recorriendo la lista:");
        for (String fruta : frutas) {
            System.out.println("- " + fruta);
        }
    }
}
