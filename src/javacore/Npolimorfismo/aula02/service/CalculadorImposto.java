package javacore.Npolimorfismo.aula02.service;

import javacore.Npolimorfismo.aula02.domain.Computador;
import javacore.Npolimorfismo.aula02.domain.Tomate;

public class CalculadorImposto {

    public static void calcularImpostoComputador(Computador computador) {
        System.out.println("Relatório de imposto do Computador");
        double imposto = computador.calcularImposto();
        System.out.println("Computador " + computador.getNome());
        System.out.println("Valor " + computador.getValor());
        System.out.println("Imposto a ser pago " + imposto);
    }
    public static void calcularImpostoTomate(Tomate tomate) {
        System.out.println("Relatório de imposto do Tomate");
        double imposto = tomate.calcularImposto();
        System.out.println("Tomate " + tomate.getNome());
        System.out.println("Valor " + tomate.getValor());
        System.out.println("Imposto a ser pago " + imposto);
    }


}
