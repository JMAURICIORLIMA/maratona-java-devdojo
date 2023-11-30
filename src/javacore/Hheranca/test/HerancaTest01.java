package javacore.Hheranca.test;

import javacore.Hheranca.dominio.Endereco;
import javacore.Hheranca.dominio.Funcionario;
import javacore.Hheranca.dominio.Pessoa;

public class HerancaTest01 {

    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.setCep("01234-56");
        endereco.setNome("Rua 3");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Toyohisa Shimazu");
        pessoa.setCpf("12345678955");
        pessoa.setEndereco(endereco);

        pessoa.imprime();

        System.out.println("------------------------");

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Oda Nobunaga");
        funcionario.setCpf("98765433245");
        funcionario.setEndereco(endereco);
        funcionario.setSalario(20000);
        funcionario.imprime();
        funcionario.pagamento();


    }
}
