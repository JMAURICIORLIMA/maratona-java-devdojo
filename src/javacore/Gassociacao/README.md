# Orientação Objetos - Associação

64 - Orientação Obejtos - Associação pt 01 - Arrays com Objetos [^01]

[^01]: Acesse o vídeo YouTube -> [64 - Orientação Obejtos - Associação pt 01 - Arrays com Objetos](https://abre.ai/hkAa)

A associação em programação orientada a objetos refere-se à relação entre objetos. Uma forma comum de associação é
quando um objeto contém uma coleção de outros objetos, como um array de objetos. Vamos explorar um exemplo de associação
usando arrays em Java:

Suponha que você tenha uma classe `Aluno` e uma classe `Turma`. Cada turma pode conter vários alunos. Vamos criar uma
associação usando um array de objetos `Aluno` na classe `Turma`:

```java
public class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

public class Turma {
    private String nomeTurma;
    private Aluno[] alunos;

    public Turma(String nomeTurma, int numeroAlunos) {
        this.nomeTurma = nomeTurma;
        this.alunos = new Aluno[numeroAlunos];
    }

    public void adicionarAluno(Aluno aluno, int indice) {
        if (indice >= 0 && indice < alunos.length) {
            alunos[indice] = aluno;
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarAlunos() {
        System.out.println("Alunos da turma " + nomeTurma + ":");
        for (Aluno aluno : alunos) {
            if (aluno != null) {
                System.out.println(aluno.getNome());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");

        Turma turmaA = new Turma("Turma A", 2);
        turmaA.adicionarAluno(aluno1, 0);
        turmaA.adicionarAluno(aluno2, 1);

        turmaA.listarAlunos();
    }
}
```

Neste exemplo:

- A classe `Aluno` representa um aluno com um nome.
- A classe `Turma` tem um array de objetos `Aluno` e métodos para adicionar alunos e listar alunos.

Este é um exemplo simples de associação em que uma classe (`Turma`) contém uma coleção de objetos de outra
classe (`Aluno`). Essa coleção poderia ser um array, uma lista ou qualquer outra estrutura de dados, dependendo das
necessidades do programa.
