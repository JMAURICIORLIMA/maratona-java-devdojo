package javacore.Fmodificadoresstatico.aula02.test;

import javacore.Fmodificadoresstatico.aula02.dominio.Carro;

public class CarroTest01 {

    public static void main(String[] args) {
        Carro.setVelocidadeLimite(180);

        Carro c1 = new Carro("BMW", 270);
        Carro c2 = new Carro("Mercedes", 265);
        Carro c3 = new Carro("Audi", 290);


        c1.imprime();
        c2.imprime();
        c3.imprime();
    }
}
