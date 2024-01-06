package javacore.Npolimorfismo.aula04.test;

import javacore.Npolimorfismo.aula04.domain.Computador;
import javacore.Npolimorfismo.aula04.domain.Tomate;
import javacore.Npolimorfismo.aula04.service.CalculadorImposto;

public class ProdutoTest04 {

    public static void main(String[] args) {
        Tomate tomate = new Tomate("Tomate Americano", 20);
        Computador computador = new Computador("Ryzen 9", 3000);

        tomate.setDataValidade("05/02/2024");

        CalculadorImposto.calcularImposto(tomate);
        System.out.println("______________________________");
        CalculadorImposto.calcularImposto(computador);

    }
}
