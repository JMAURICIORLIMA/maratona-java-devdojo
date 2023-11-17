package javacore.Gassociacao.aula01.test;

import javacore.Gassociacao.aula01.dominio.Jogador;

public class JogadorTest01 {

    public static void main(String[] args) {

        Jogador jogador1 = new Jogador("Pelé");
        Jogador jogador2 = new Jogador("Romário");
        Jogador jogador3 = new Jogador("Cafu");

//        3 formas de criar um array.
//        1ª - Jogador[] jogadors = new Jogador[3];
//        2ª - Jogador[] jogadors = new Jogador[]{jogador1, jogador2, jogador3};
//        3ª - Criar o array e já informando o tamanho e fazendo a referência aos 3 objetos idependentes.
        Jogador[] jogadores = {jogador1, jogador2, jogador3};

        for (Jogador jogador : jogadores) {
            jogador.imprime();
        }

    }
}
