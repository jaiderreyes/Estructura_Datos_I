/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bescatotiendaapp;

/**
 *
 * @author jaiderreyes
 */


import java.util.ArrayList;

  

// Clase base Persona
class Persona {
    protected String nombre;
    protected String documento;

    public Persona(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " | Documento: " + documento);
    }
}

// Cliente hereda de Persona
class Cliente extends Persona {
    private double saldo;

    public Cliente(String nombre, String documento, double saldo) {
        super(nombre, documento);
        this.saldo = saldo;
    }

    public void comprar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println(nombre + " realizó una compra de $" + monto);
        } else {
            System.out.println("Saldo insuficiente para " + nombre);
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

// Empleado hereda de Persona
class Empleado extends Persona {
    private String cargo;

    public Empleado(String nombre, String documento, String cargo) {
        super(nombre, documento);
        this.cargo = cargo;
    }

    public void trabajar() {
        System.out.println(nombre + " está trabajando como " + cargo);
    }
}

// Clase para prendas de ropa
class Prenda {
    private String tipo;
    private String talla;
    private double precio;
    private int cantidad;

    public Prenda(String tipo, String talla, double precio, int cantidad) {
        this.tipo = tipo;
        this.talla = talla;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public boolean vender(int cantidadVendida) {
        if (cantidad >= cantidadVendida) {
            cantidad -= cantidadVendida;
            return true;
        }
        return false;
    }

    public String getDescripcion() {
        return tipo + " talla " + talla;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}

// Clase principal de la tienda
class BescatoTienda {
    private String nombre;
    private ArrayList<Prenda> inventario;
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;

    public BescatoTienda(String nombre) {
        this.nombre = nombre;
        inventario = new ArrayList<>();
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    public void agregarPrenda(Prenda prenda) {
        inventario.add(prenda);
    }

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void listarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for (Prenda p : inventario) {
            System.out.println(p.getDescripcion() + " - Precio: $" + p.getPrecio() + " - Stock: " + p.getCantidad());
        }
    }

    public void venderPrenda(String descripcion, int cantidad, Cliente cliente) {
        for (Prenda p : inventario) {
            if (p.getDescripcion().equalsIgnoreCase(descripcion) && p.getCantidad() >= cantidad) {
                double total = p.getPrecio() * cantidad;
                if (cliente.getSaldo() >= total) {
                    p.vender(cantidad);
                    cliente.comprar(total);
                    System.out.println("Venta realizada: " + descripcion + " x" + cantidad);
                } else {
                    System.out.println("El cliente no tiene saldo suficiente.");
                }
                return;
            }
        }
        System.out.println("Prenda no disponible en inventario.");
    }
}
 public class BescatoTiendaApp {

    public static void main(String[] args) {
       // BescatoTiendaApp tienda = new BescatoTienda("Bescato Tienda");
BescatoTienda tienda = new BescatoTienda("Bescato Tienda");

        // Empleados
        Empleado e1 = new Empleado("María López", "101010", "Vendedora");
        tienda.agregarEmpleado(e1);

        // Clientes
        Cliente c1 = new Cliente("Juan Torres", "202020", 300);
        tienda.agregarCliente(c1);

        // Prendas
        Prenda p1 = new Prenda("Camiseta", "M", 50.0, 20);
        Prenda p2 = new Prenda("Pantalón", "L", 80.0, 10);
        tienda.agregarPrenda(p1);
        tienda.agregarPrenda(p2);

        // Mostrar inventario
        tienda.listarInventario();

        // Venta simulada
        tienda.venderPrenda("Camiseta talla M", 2, c1);

        // Mostrar saldo restante del cliente
        System.out.println("Saldo actual de " + c1.nombre + ": $" + c1.getSaldo());

        // Mostrar empleado trabajando
        e1.trabajar();
    }
}

