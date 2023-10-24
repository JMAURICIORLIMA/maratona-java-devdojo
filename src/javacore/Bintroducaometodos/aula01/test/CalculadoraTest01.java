package javacore.Bintroducaometodos.aula01.test;

import javacore.Bintroducaometodos.aula01.dominio.Calculadora;

public class CalculadoraTest01 {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        calculadora.somaDoisNumeros();

        System.out.println("Finalizando método somaDoisNumeros");

        calculadora.subtraiDoisNumeros();

        System.out.println("Finalizando métodos subtraiDoisNumeros e Classe CalculadoraTest01");
    }
}
