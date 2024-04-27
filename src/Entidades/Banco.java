package Entidades;

public class Banco {
    private double saldoBanco = 0.0;

    public synchronized void transferir(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
            saldoBanco += valor;
            System.out.println("Transferência de R$" + valor + " realizada.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public synchronized double getSaldoBanco() {
        return saldoBanco;
    }
}
