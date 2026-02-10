package com.xyz.banco;

public class CuentaAhorros extends Cuenta {
    public CuentaAhorros(String numero, double saldoInicial) { super(numero, saldoInicial); }
    @Override public String tipo() { return "Ahorros"; }
}
