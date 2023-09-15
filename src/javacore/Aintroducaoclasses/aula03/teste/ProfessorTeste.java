package javacore.Aintroducaoclasses.aula03.teste;

import javacore.Aintroducaoclasses.aula03.dominio.Professor;

public class ProfessorTeste {

    public static void main(String[] args) {

        Professor professor = new Professor();

        professor.nome = "Mestre Kami";
        professor.idade = 150;
        professor.sexo = 'M';

        System.out.println("Nome: " + professor.nome + ", idade: " + professor.idade + ", sexo: " + professor.sexo);
    }
}
