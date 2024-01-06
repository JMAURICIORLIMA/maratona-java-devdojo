package javacore.Npolimorfismo.aula03.service;

import javacore.Npolimorfismo.aula03.domain.Produto;

public class CalculadorImposto {
    public static void calcularImposto(Produto produto) {
        System.out.println("Relatório de imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Preço: " + produto.getValor());
        System.out.println("Imposto a ser pago: " + imposto);
    }

}
