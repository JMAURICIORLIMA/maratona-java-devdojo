package javacore.Csobrecargametodos.aula01.test;

import javacore.Csobrecargametodos.aula01.dominio.Anime;

public class AnimeTest01 {

    public static void main(String[] args) {

        Anime anime = new Anime();
        anime.init("Akudama Drive", "TV", 12);
        anime.init("Akudama Drive", "TV", 12, "Ação");
//        anime.setNome("Akudama Drive");
//        anime.setTipo("TV");
//        anime.setEpsodios(12);
        anime.imprime();

    }
}
