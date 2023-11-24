package javacore.Gassociacao.exerciciofixacao.correcao.test;

import javacore.Gassociacao.exerciciofixacao.correcao.dominio.Aluno;
import javacore.Gassociacao.exerciciofixacao.correcao.dominio.Local;
import javacore.Gassociacao.exerciciofixacao.correcao.dominio.Professor;
import javacore.Gassociacao.exerciciofixacao.correcao.dominio.Seminario;

public class AssociacaoTest {

    public static void main(String[] args) {

        Local local = new Local("Rua das laranjeiras");

        Aluno aluno = new Aluno("Luffy", 17);

        Professor professor = new Professor("Barba Branca", "Pirata");

        Aluno[] alunosParaSeminario = {aluno};

        Seminario seminario = new Seminario("Onde achar One Piece", alunosParaSeminario, local);

        Seminario[] seminariosDosponiveis = {seminario};

        professor.setSeminarios(seminariosDosponiveis);


        professor.imprime();

    }
}
