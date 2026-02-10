/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemainventariocalzado2;
import java.util.List;
/**
 *
 * @author jaiderreyes
 */
public abstract class Inventario {
 protected List<Calzado> lista;

    public Inventario(List<Calzado> lista) {
        this.lista = lista;
    }

    public abstract void    agregarCalzado(Calzado c);
    public abstract Calzado buscarCalzado(String codigo);
    public abstract boolean eliminarCalzado(String codigo);

    // ¡IMPORTANTE! debe ser public para que sea visible desde el Main
    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("----- Inventario de Calzado -----");
            for (Calzado c : lista) {
                System.out.println(c);
            }
        }
    }
}
