package javacore.Dconstrutores.aula01.test;

import javacore.Dconstrutores.aula01.dominio.Anime;

public class AnimeTest01 {

    public static void main(String[] args) {

        Anime anime = new Anime("Akudama Drive", "TV", 12, "Ação");
        Anime anime02 = new Anime();

        anime.imprime();
        anime02.imprime();

    }
}
