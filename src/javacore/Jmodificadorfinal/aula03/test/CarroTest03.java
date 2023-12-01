package javacore.Jmodificadorfinal.aula03.test;

import javacore.Jmodificadorfinal.aula03.dominio.Carro;
import javacore.Jmodificadorfinal.aula03.dominio.Ferrari;

public class CarroTest03 {

    public static void main(String[] args) {

        Carro carro = new Carro();

        System.out.println(Carro.VELOCIDADE_LIMITE);
        System.out.println(carro.COMPRADOR);
        carro.COMPRADOR.setNome("Kuririn");
        System.out.println(carro.COMPRADOR);

        Ferrari ferrari = new Ferrari();
        ferrari.setNome("Enzo");
        ferrari.imprime();
    }
}
