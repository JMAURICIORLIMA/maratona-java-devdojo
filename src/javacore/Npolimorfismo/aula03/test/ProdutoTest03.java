package javacore.Npolimorfismo.aula03.test;

import javacore.Npolimorfismo.aula03.domain.Computador;
import javacore.Npolimorfismo.aula03.domain.Televisao;
import javacore.Npolimorfismo.aula03.domain.Tomate;
import javacore.Npolimorfismo.aula03.service.CalculadorImposto;

public class ProdutoTest03 {

    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7", 11000);
        Tomate tomate = new Tomate("Tomate Siciliano", 10);
        Televisao tv = new Televisao("Samsung 50\" ", 5000);

        CalculadorImposto.calcularImposto(computador);
        System.out.println("--------------------------------");
        CalculadorImposto.calcularImposto(tomate);
        System.out.println("--------------------------------");
        CalculadorImposto.calcularImposto(tv);

    }
}
