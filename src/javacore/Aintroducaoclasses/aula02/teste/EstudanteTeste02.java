package javacore.Aintroducaoclasses.aula02.teste;

import javacore.Aintroducaoclasses.aula02.dominio.Estudante;

public class EstudanteTeste02 {

    public static void main(String[] args) {

        Estudante estudante1 = new Estudante();
        Estudante estudante2 = new Estudante();

        // Inicialização sem atributos definitos - Impressão de valor padrão.
        System.out.println("** estudante1 **");
        estudante1.nome = "Sanji"; // Modificando atribuição de estudante1.nome
        System.out.println("Nome: " + estudante1.nome);
        System.out.println("Idade: " + estudante1.idade);
        System.out.println("Sexo: " + estudante1.sexo);

        System.out.println("-----------------------------");

        System.out.println("** estudante2 **");
        System.out.println("Nome: " + estudante2.nome);
        System.out.println("Idade: " + estudante2.idade);
        System.out.println("Sexo: " + estudante2.sexo);
    }

}
