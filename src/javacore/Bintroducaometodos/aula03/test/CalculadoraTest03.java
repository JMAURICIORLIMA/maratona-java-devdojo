package javacore.Bintroducaometodos.aula03.test;


import javacore.Bintroducaometodos.aula03.dominio.Calculadora;

public class CalculadoraTest03 {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        double result = calculadora.divideDoisNumeros(20, 0);
        System.out.println("Métodos divideDoisNumeros");
        System.out.println(result);

        System.out.println("\nMétodos divideDoisNumeros02");
        System.out.println(calculadora.divideDoisNumeros02(81, 3));

        System.out.println("\nMétodo imprimeDivisaoDeDoisNumeros");
        calculadora.imprimeDivisaoDeDoisNumeros(10, 15);

    }
}
