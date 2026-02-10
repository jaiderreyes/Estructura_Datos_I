package com.xyz.banco;

public class Cliente extends Persona {
    private CuentaAhorros ahorro;
    private CuentaCorriente corriente;

    public Cliente(String id, String nombre) { super(id, nombre); }

    public CuentaAhorros getAhorro() { return ahorro; }
    public CuentaCorriente getCorriente() { return corriente; }

    public void asignarAhorros(CuentaAhorros c) { this.ahorro = c; }
    public void asignarCorriente(CuentaCorriente c) { this.corriente = c; }

    public boolean tieneAhorro() { return ahorro != null; }
    public boolean tieneCorriente() { return corriente != null; }

    @Override public String toString() {
        return super.toString()+" | "+(tieneAhorro()? ahorro : "sin ahorro")+" | "+(tieneCorriente()? corriente : "sin corriente");
    }
}
