package javacore.Lclassesabstratas.aula03.test;

import javacore.Lclassesabstratas.aula03.domain.Desenvolvedor;
import javacore.Lclassesabstratas.aula03.domain.Gerente;

public class FuncionarioTest03 {

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Nami", 5000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Touya", 12000);

        System.out.println(gerente);
        System.out.println(desenvolvedor);

        gerente.imprime();
        desenvolvedor.imprime();
    }

}
