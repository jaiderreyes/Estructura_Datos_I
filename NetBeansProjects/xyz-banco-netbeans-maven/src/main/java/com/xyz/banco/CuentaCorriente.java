package com.xyz.banco;

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(String numero, double saldoInicial) { super(numero, saldoInicial); }
    @Override public String tipo() { return "Corriente"; }
}
