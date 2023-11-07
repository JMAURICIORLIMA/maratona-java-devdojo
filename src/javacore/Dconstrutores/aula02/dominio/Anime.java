package javacore.Dconstrutores.aula02.dominio;

public class Anime {

    private String nome;
    private String tipo;
    private int epsodios;
    private String genero;
    private String estudio;

    public Anime() {
        System.out.println("Dentro do contrutor sem argumentos.");
    }
    public Anime(String nome, String tipo, int epsodios, String genero) {
        this();
        this.nome = nome;
        this.tipo = tipo;
        this.epsodios = epsodios;
        this.genero = genero;
    }

    public Anime(String nome, String tipo, int epsodios, String genero, String estudio) {
        this(nome, tipo, epsodios, genero);
        this.estudio = estudio;
    }
    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.tipo);
        System.out.println(this.epsodios);
        System.out.println(this.genero);
        System.out.println(this.estudio);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEpsodios(int epsodios) {
        this.epsodios = epsodios;
    }

    public int getEpsodios() {
        return epsodios;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
