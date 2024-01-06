package javacore.Npolimorfismo.aula04.service;

import javacore.Npolimorfismo.aula04.domain.Produto;
import javacore.Npolimorfismo.aula04.domain.Tomate;

public class CalculadorImposto {
    public static void calcularImposto(Produto produto) {
        System.out.println("Relatório de imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Preço: " + produto.getValor());
        System.out.println("Imposto a ser pago: " + imposto);
        if (produto instanceof Tomate tomate) {
            System.out.println(tomate.getDataValidade());
        }
    }

}
