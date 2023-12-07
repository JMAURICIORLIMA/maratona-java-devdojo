package javacore.Lclassesabstratas.aula02.test;


import javacore.Lclassesabstratas.aula02.domain.Desenvolvedor;
import javacore.Lclassesabstratas.aula02.domain.Gerente;

public class FuncionarioTest02 {

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Nami", 5000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Touya", 12000);

        System.out.println(gerente);
        System.out.println(desenvolvedor);

    }

}
