package Entidades;

public class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimento;
    private Loja loja;

    public Funcionario(Loja loja) {
        this.loja = loja;
        this.contaSalario = loja.getConta();
        this.contaInvestimento = new Conta();
    }

    @Override
    public void run() {
        double salario = 1400.0;
        double investimento = salario * 0.2;
        contaSalario.debitar(salario); 
        contaInvestimento.creditar(investimento); 
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public void receberSalario() {
        contaSalario.creditar(1400.0);
    }
}
