package javacore.Gassociacao.exerciciofixacao.exercitando.dominio;

public class Seminario {

    private String titulo;
    private String endereco;
    private Aluno aluno;
    private Local localidade;

    public Seminario(String titulo) {
        this.titulo = titulo;
    }

    public void consultaSeminario(Aluno aluno, Seminario seminario) {
        if (aluno.getSeminario().getLocalidade() != seminario.getLocalidade()) {
            System.out.println("Aluno não pode está cadastrado em mais de 1 seminário");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Local getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Local localidade) {
        this.localidade = localidade;
    }
}
