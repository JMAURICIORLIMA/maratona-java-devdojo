package javacore.Npolimorfismo.test;

import javacore.Npolimorfismo.domain.Computador;
import javacore.Npolimorfismo.domain.Tomate;
import javacore.Npolimorfismo.service.CalculadorImposto;

public class ProdutoTest01 {

    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7", 11000);
        Tomate tomate = new Tomate("Tomate Siciliano", 10);

        CalculadorImposto.calcularImpostoComputador(computador);
        System.out.println("--------------------------------");
        CalculadorImposto.calcularImpostoTomate(tomate);
    }
}
