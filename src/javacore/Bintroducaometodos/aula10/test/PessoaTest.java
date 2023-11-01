package javacore.Bintroducaometodos.aula10.test;

import javacore.Bintroducaometodos.aula10.dominio.Pessoa;

public class PessoaTest {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();

        pessoa.setName("Jiraya");
        pessoa.setAge(70);

        pessoa.print();
    }
}
