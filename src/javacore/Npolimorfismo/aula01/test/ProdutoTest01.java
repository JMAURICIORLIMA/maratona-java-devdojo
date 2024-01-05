package javacore.Npolimorfismo.aula01.test;

import javacore.Npolimorfismo.aula01.domain.Computador;
import javacore.Npolimorfismo.aula01.domain.Tomate;
import javacore.Npolimorfismo.aula01.service.CalculadorImposto;

public class ProdutoTest01 {

    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7", 11000);
        Tomate tomate = new Tomate("Tomate Siciliano", 10);

        CalculadorImposto.calcularImpostoComputador(computador);
        System.out.println("--------------------------------");
        CalculadorImposto.calcularImpostoTomate(tomate);
    }
}
