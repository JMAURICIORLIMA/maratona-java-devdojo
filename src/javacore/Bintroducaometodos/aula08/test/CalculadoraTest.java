package javacore.Bintroducaometodos.aula08.test;

import javacore.Bintroducaometodos.aula08.dominio.Calculadora;

public class CalculadoraTest {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        int[] arrayDeNumeros = {1,2,3,4,5};

        calculadora.somaArray(arrayDeNumeros);

        calculadora.somaVarArgs(1,2,3,4,5,6,7,8);
    }
}
