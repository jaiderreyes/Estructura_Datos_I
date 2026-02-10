package com.xyz.banco;

public class Empleado extends Persona {
    private String cargo;
    private double salario;

    public Empleado(String id, String nombre, String cargo, double salario) {
        super(id, nombre); this.cargo = cargo; this.salario = salario;
    }
    public String getCargo() { return cargo; }
    public double getSalario() { return salario; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override public String toString() { return super.toString()+" | "+cargo+" | $"+String.format("%.2f", salario); }
}
