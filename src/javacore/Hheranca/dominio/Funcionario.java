package javacore.Hheranca.dominio;

public class Funcionario extends Pessoa {

    private double salario;

    public Funcionario(String nome) {
        super(nome);
    }

    @Override
    public void imprime() {
        super.imprime();
        System.out.println("Salário R$" + this.salario);
    }

    public void pagamento() {
        System.out.println("Eu " + this.nome + ", declaro que recebi o valor de R$ " + this.salario +
                " referente ao salário.");
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
