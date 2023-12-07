package javacore.Lclassesabstratas.aula01.test;

import javacore.Lclassesabstratas.aula01.domain.Desenvolvedor;
import javacore.Lclassesabstratas.aula01.domain.Gerente;

public class FuncionarioTest01 {

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Nami", 5000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Touya", 12000);

        System.out.println(gerente);
        System.out.println(desenvolvedor);

    }

}
