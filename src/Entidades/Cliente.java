package Entidades;

import java.util.Random;

public class Cliente extends Thread {
    private Conta conta;
    private Banco banco;
    private static Random random = new Random();

    public Cliente(Conta conta, Banco banco) {
        this.conta = conta;
        this.banco = banco;
    }

    @Override
    public void run() {
        while (true) {
            int valorCompra = random.nextBoolean() ? 100 : 200;
            if (conta.getSaldo() >= valorCompra) {
                conta.debitar(valorCompra);
                System.out.println(Thread.currentThread().getName() + " efetuou uma compra de R$" + valorCompra);
            } else {
                break;
            }
        }
    }
}