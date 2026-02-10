package com.xyz.banco;

public abstract class Cuenta {
    protected String numero;
    protected double saldo;

    public Cuenta(String numero, double saldoInicial) {
        this.numero = numero; this.saldo = saldoInicial;
    }
    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        saldo += monto;
    }
    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        if (saldo < monto) throw new IllegalArgumentException("Fondos insuficientes");
        saldo -= monto;
    }

    public abstract String tipo();
    @Override public String toString() { return tipo()+"{num="+numero+", saldo="+String.format("%.2f", saldo)+"}"; }
}
