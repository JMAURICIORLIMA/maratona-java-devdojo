package javacore.Gassociacao.exerciciofixacao.exercitando.test;

import javacore.Gassociacao.exerciciofixacao.exercitando.dominio.Aluno;
import javacore.Gassociacao.exerciciofixacao.exercitando.dominio.Local;
import javacore.Gassociacao.exerciciofixacao.exercitando.dominio.Professor;
import javacore.Gassociacao.exerciciofixacao.exercitando.dominio.Seminario;

public class AssociacaoTest {

    public static void main(String[] args) {

        Local localidade = new Local("Centro de convenções");
        Aluno aluno01 = new Aluno("João", 19);
        Aluno aluno02 = new Aluno("Felipe", 23);
        Aluno aluno03 = new Aluno("Marcia", 21);
        Professor professor01 = new Professor("William", "Especialista em desenvolvimento Java");
        Professor professor02 = new Professor("Gustavo", "Desenvolvimento Web");
        Seminario seminario1 = new Seminario("Desenvolvimento Java");
        Seminario seminario2 = new Seminario("Banco de dados");

        seminario1.setAluno(aluno01);
        seminario1.setAluno(aluno02);

        seminario1.setLocalidade(localidade);

        aluno01.setSeminario(seminario1);
        aluno01.setSeminario(seminario2);

        System.out.println("Nome " + aluno01.getNome() + " idade " + aluno01.getIdade());
        System.out.println(seminario1.getAluno().getNome());
        System.out.println(seminario1.getTitulo());
        System.out.println(seminario1.getEndereco());
        System.out.println(seminario1.getLocalidade().getEndereco());
        System.out.println(professor01.getEspecialidade());
        System.out.println("Aluno: " + aluno01.getNome() + ", está cadastrado no seminário de: " + aluno01.getSeminario().getTitulo());

        seminario1.consultaSeminario(aluno01, seminario1);

    }
}
