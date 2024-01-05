package javacore.Npolimorfismo.aula02.test;

import javacore.Npolimorfismo.aula02.domain.Computador;
import javacore.Npolimorfismo.aula02.domain.Produto;
import javacore.Npolimorfismo.aula02.domain.Tomate;
import javacore.Npolimorfismo.aula02.service.CalculadorImposto;

public class ProdutoTest02 {

    public static void main(String[] args) {
        Produto produto1 = new Computador("Ryzen 9", 3000);
        Produto produto2 = new Tomate("Tomate Americano", 20);

        System.out.println(produto1.getNome());
        System.out.println(produto1.getValor());
        System.out.println(produto1.calcularImposto());

        System.out.println("______________________________");

        System.out.println(produto2.getNome());
        System.out.println(produto2.getValor());
        System.out.println(produto2.calcularImposto());

    }
}
