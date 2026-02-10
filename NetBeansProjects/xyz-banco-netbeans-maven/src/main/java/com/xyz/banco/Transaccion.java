package com.xyz.banco;

import java.time.LocalDateTime;

public class Transaccion {
    public enum Tipo { DEPOSITO, RETIRO, CONSULTA }
    private final Tipo tipo;
    private final String numeroCuenta;
    private final double monto;
    private final LocalDateTime fecha;

    public Transaccion(Tipo tipo, String numeroCuenta, double monto) {
        this.tipo = tipo; this.numeroCuenta = numeroCuenta; this.monto = monto;
        this.fecha = LocalDateTime.now();
    }
    public Tipo getTipo() { return tipo; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public double getMonto() { return monto; }
    public LocalDateTime getFecha() { return fecha; }

    @Override public String toString() {
        return fecha+" "+tipo+" "+numeroCuenta+" monto="+String.format("%.2f", monto);
    }
}
