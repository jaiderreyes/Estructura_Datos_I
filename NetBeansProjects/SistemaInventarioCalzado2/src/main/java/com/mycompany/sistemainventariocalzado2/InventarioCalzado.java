/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemainventariocalzado2;
 import java.util.ArrayList;
/**
 *
 * @author jaiderreyes
 */
public class InventarioCalzado extends Inventario {
   
   
    public InventarioCalzado() {
        super(new ArrayList<>());
    }

    @Override
    public void agregarCalzado(Calzado c) {
        lista.add(c);
        System.out.println("✓ Calzado agregado: " + c.getCodigo());
    }

    @Override
    public Calzado buscarCalzado(String codigo) {
        for (Calzado c : lista) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarCalzado(String codigo) {
        Calzado c = buscarCalzado(codigo);
        if (c != null) {
            lista.remove(c);
            System.out.println("✗ Calzado eliminado: " + codigo);
            return true;
        }
        return false;
    }
    // No hace falta redeclarar listar() aquí: la heredas de Inventario
}