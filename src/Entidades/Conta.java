package Entidades;

public class Conta {
    private double saldo = 1000.0;

    public synchronized void creditar(double valor) {
        saldo += valor;
    }

    public synchronized void debitar(double valor) {
        saldo -= valor;
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}
