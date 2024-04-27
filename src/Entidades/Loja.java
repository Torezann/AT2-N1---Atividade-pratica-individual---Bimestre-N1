package Entidades;

public class Loja {
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(int numFuncionarios) {
        conta = new Conta();
        funcionarios = new Funcionario[numFuncionarios];
        for (int i = 0; i < numFuncionarios; i++) {
            funcionarios[i] = new Funcionario(this);
        }
    }

    public Conta getConta() {
        return conta;
    }

    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public void pagarSalarios() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.receberSalario(); 
        }
    }
}