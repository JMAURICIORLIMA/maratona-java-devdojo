package javacore.Jmodificadorfinal.aula02.test;

import javacore.Jmodificadorfinal.aula02.dominio.Carro;

public class CarroTest02 {

    public static void main(String[] args) {

        Carro carro = new Carro();

        System.out.println(Carro.VELOCIDADE_LIMITE);
        System.out.println(carro.COMPRADOR);
        carro.COMPRADOR.setNome("Kuririn");
        System.out.println(carro.COMPRADOR);

    }
}
