package com.xyz.banco;

import java.util.Scanner;

public class Main {
    private static final Banco banco = new Banco();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seed();
        while (true) {
            menu();
            String op = sc.nextLine().trim();
            try {
                switch (op) {
                    case "1" -> banco.listarClientes();
                    case "2" -> banco.listarClientesAhorro();
                    case "3" -> banco.listarClientesCorriente();
                    case "4" -> subTransacciones();
                    case "5" -> banco.listarNomina();
                    case "6" -> subClientes();
                    case "7" -> subEmpleados();
                    case "8" -> { banco.listarTransacciones(); }
                    case "0" -> { System.out.println("Fin."); return; }
                    default -> System.out.println("Opción inválida");
                }
            } catch (Exception e) { System.out.println("Error: "+e.getMessage()); }
            System.out.println("---");
        }
    }

    static void menu() {
        System.out.println("""

        1) Listado general de clientes
        2) Listado clientes con cuenta de ahorro
        3) Listado clientes con cuenta corriente
        4) Transacciones (depósito, retiro, consulta)
        5) Nómina de empleados
        6) Clientes (buscar/actualizar/eliminar/abrir cuentas)
        7) Empleados (buscar/actualizar/eliminar/agregar)
        8) Ver transacciones
        0) Salir
        """);
        System.out.print("Opción: ");
    }

    static void subTransacciones() {
        System.out.println("[1] Depositar  [2] Retirar  [3] Consultar saldo");
        String o = sc.nextLine().trim();
        System.out.print("Número de cuenta: "); String num = sc.nextLine().trim();
        switch (o) {
            case "1" -> {
                System.out.print("Monto: "); double m = Double.parseDouble(sc.nextLine());
                System.out.println(banco.depositar(num, m) ? "Depósito OK" : "Cuenta no encontrada");
            }
            case "2" -> {
                System.out.print("Monto: "); double m = Double.parseDouble(sc.nextLine());
                try {
                    System.out.println(banco.retirar(num, m) ? "Retiro OK" : "Cuenta no encontrada");
                } catch (IllegalArgumentException e) { System.out.println("Error: "+e.getMessage()); }
            }
            case "3" -> {
                Double s = banco.consultarSaldo(num);
                System.out.println(s==null ? "Cuenta no encontrada" : "Saldo: "+String.format("%.2f", s));
            }
            default -> System.out.println("Opción inválida");
        }
    }

    static void subClientes() {
        System.out.println("[1] Buscar  [2] Actualizar nombre  [3] Eliminar  [4] Abrir Ahorros  [5] Abrir Corriente");
        String o = sc.nextLine().trim();
        System.out.print("ID cliente: "); String id = sc.nextLine().trim();
        switch (o) {
            case "1" -> {
                Cliente c = banco.buscarCliente(id);
                System.out.println(c==null ? "No existe" : c);
            }
            case "2" -> {
                System.out.print("Nuevo nombre: "); String n = sc.nextLine();
                System.out.println(banco.actualizarClienteNombre(id, n) ? "Actualizado" : "No existe");
            }
            case "3" -> System.out.println(banco.eliminarCliente(id) ? "Eliminado" : "No existe");
            case "4" -> {
                System.out.print("Num cuenta: "); String num = sc.nextLine();
                System.out.print("Saldo inicial: "); double s = Double.parseDouble(sc.nextLine());
                System.out.println(banco.abrirAhorros(id, num, s) ? "Ahorros creada" : "No se pudo crear");
            }
            case "5" -> {
                System.out.print("Num cuenta: "); String num = sc.nextLine();
                System.out.print("Saldo inicial: "); double s = Double.parseDouble(sc.nextLine());
                System.out.println(banco.abrirCorriente(id, num, s) ? "Corriente creada" : "No se pudo crear");
            }
            default -> System.out.println("Opción inválida");
        }
    }

    static void subEmpleados() {
        System.out.println("[1] Buscar  [2] Actualizar  [3] Eliminar  [4] Agregar");
        String o = sc.nextLine().trim();
        System.out.print("ID empleado: "); String id = sc.nextLine().trim();
        switch (o) {
            case "1" -> {
                // búsqueda lineal simple: mostramos nómina completa
                banco.listarNomina();
            }
            case "2" -> {
                System.out.print("Nuevo cargo: "); String cargo = sc.nextLine();
                System.out.print("Nuevo salario: "); double sal = Double.parseDouble(sc.nextLine());
                System.out.println(banco.actualizarEmpleado(id, cargo, sal) ? "Actualizado" : "No existe");
            }
            case "3" -> System.out.println(banco.eliminarEmpleado(id) ? "Eliminado" : "No existe");
            case "4" -> {
                System.out.print("Nombre: "); String nom = sc.nextLine();
                System.out.print("Cargo: "); String cargo = sc.nextLine();
                System.out.print("Salario: "); double sal = Double.parseDouble(sc.nextLine());
                System.out.println(banco.agregarEmpleado(new Empleado(id, nom, cargo, sal)) ? "Agregado" : "No se pudo agregar");
            }
            default -> System.out.println("Opción inválida");
        }
    }

    static void seed() {
        banco.agregarCliente(new Cliente("C001","Ana"));
        banco.agregarCliente(new Cliente("C002","Luis"));
        banco.abrirAhorros("C001","AH-1001", 500);
        banco.abrirCorriente("C002","CC-2001", 300);

        banco.agregarEmpleado(new Empleado("E001","Marta","Cajera", 1800000));
        banco.agregarEmpleado(new Empleado("E002","Diego","Asesor", 2300000));
    }
}
