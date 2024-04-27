package Aplicacao;

import Entidades.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Loja loja1 = new Loja(2);
        Loja loja2 = new Loja(2);
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(loja1.getConta(), banco);
            clientes[i].start();
        }

        loja1.pagarSalarios();
        loja2.pagarSalarios();
        
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Saldo final das contas:");
        System.out.println("Conta da Loja 1: R$" + loja1.getConta().getSaldo());
        System.out.println("Conta da Loja 2: R$" + loja2.getConta().getSaldo());
        for (Funcionario funcionario : loja1.getFuncionarios()) {
            System.out.println("Conta do Funcionário da Loja 1: R$" + funcionario.getContaSalario().getSaldo());
            System.out.println("Conta de Investimento do Funcionário da Loja 1: R$" + funcionario.getContaInvestimento().getSaldo());
        }
        for (Funcionario funcionario : loja2.getFuncionarios()) {
            System.out.println("Conta do Funcionário da Loja 2: R$" + funcionario.getContaSalario().getSaldo());
            System.out.println("Conta de Investimento do Funcionário da Loja 2: R$" + funcionario.getContaInvestimento().getSaldo());
        }

        System.out.println("Saldo do Banco: R$" + banco.getSaldoBanco());
    }
}