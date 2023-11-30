package javacore.Fmodificadoresstatico.aula03.dominio;

public class Anime {

    private String nome;
    private static int[] episodios;

//    0 - Bloco de inicialização estático é executado quando a JVM carregar a classe
//    1 - Aloca espaço em memória
//    2 - Cada atributo da classe é criado e inicializadocom valores default ou o que for passaso.
//    3 - Bloco de inicialização é executado.
//    4 - O construtor é executado.

    static {
        System.out.println("Dentro do bloco de inicalização static - 1");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }

    static {
        System.out.println("Dentro do bloco de inicalização static - 2");
    }

    static {
        System.out.println("Dentro do bloco de inicalização static - 3");
    }

    {
        System.out.println("Dentro do bloco de inicialização não static");
    }
    public Anime() {
        for (int epsodio : episodios) {
            System.out.print(epsodio + " ");
        }
        System.out.println();
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
        Anime.episodios = episodios;
    }
}
