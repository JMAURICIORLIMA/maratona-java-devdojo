package javacore.Bintroducaometodos.aula04.test;

import javacore.Bintroducaometodos.aula04.dominio.Calculadora;

public class CalculadoraTest04 {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        int a = 1;
        int b = 2;

        calculadora.alteraDoisNumeros(a, b);
        System.out.println("CalculadoraTest04");
        System.out.println("A " + a);
        System.out.println("B " + b);
    }
}
