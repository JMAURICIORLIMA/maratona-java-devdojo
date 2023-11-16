package javacore.Eblocosinicializacao.aula01.dominio;

public class Anime {

    private String nome;
    private int[] episodios;

//    1 - Aloca espaço em memória
//    2 - Cada atributo da classe é criado e inicializadocom valores default ou o que for passaso.
//    3 - Bloco de inicialização é executado.
//    4 - O construtor é executado.

    {
        System.out.println("Dentro do bloco de inicalização");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
            System.out.print(episodios[i] + " ");
        }
        System.out.println();
    }

    public Anime() {
        for (int epsodio : episodios) {
            System.out.println(epsodio + " ");
        }
    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int[] episodios) {
        this.episodios = episodios;
    }
}
