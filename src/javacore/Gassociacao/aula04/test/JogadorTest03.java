package javacore.Gassociacao.aula04.test;

import javacore.Gassociacao.aula04.dominio.Jogador;
import javacore.Gassociacao.aula04.dominio.Time;

public class JogadorTest03 {
    public static void main(String[] args) {

        Jogador jogador1 = new Jogador("Cafu");
        Time time = new Time("Brasil");

        Jogador jogador2 = new Jogador("Pelé", time);

        Jogador[] jogadores = {jogador1, jogador2};

        jogador1.setTime(time);

        time.setJogadores(jogadores);

        System.out.println("------ Jogador ------");
        jogador1.imprime();
        jogador2.imprime();

        System.out.println("------- Time -------");
        time.imprime();
    }
}
