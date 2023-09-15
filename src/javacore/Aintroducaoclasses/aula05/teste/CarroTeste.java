package javacore.Aintroducaoclasses.aula05.teste;

import javacore.Aintroducaoclasses.aula05.dominio.Carro;

public class CarroTeste {

    public static void main(String[] args) {

        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.nome = "Civic";
        carro1.modelo = "SI";
        carro1.ano = 2023;

        carro2.nome = "Viper";
        carro2.modelo = "SRT";
        carro2.ano = 2015;

        System.out.println("Marca: " + carro1.nome);
        System.out.println("Modelo: " + carro1.modelo);
        System.out.println("Ano: " + carro1.ano);

        System.out.println("----------------------------");

        System.out.println("Marca: " + carro2.nome);
        System.out.println("Modelo: " + carro2.modelo);
        System.out.println("Ano: " + carro2.ano);


    }
}
