/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemainventariocalzado2;

public class Calzado {
    private String codigo;
    private String marca;
    private String talla;
    private double precio;
    private int cantidad;

    public Calzado(String codigo, String marca, String talla, double precio, int cantidad) {
        this.codigo   = codigo;
        this.marca    = marca;
        this.talla    = talla;
        this.precio   = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo()   { return codigo; }
    public String getMarca()    { return marca; }
    public String getTalla()    { return talla; }
    public double getPrecio()   { return precio; }
    public int    getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s – Talla %s | $%.2f | Stock: %d",
                             codigo, marca, talla, precio, cantidad);
    }
}