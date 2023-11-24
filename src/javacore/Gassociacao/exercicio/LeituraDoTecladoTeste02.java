package javacore.Gassociacao.exercicio;

import java.util.Scanner;

public class LeituraDoTecladoTeste02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("O grande software de previsão do futuro\n" +
                "Digite sua pergunta e eu responderei sim ou não.");

        String pergunta = input.nextLine();

        if (pergunta.charAt(0) == ' ') {
            System.out.println("SIM");
        } else {
            System.out.println("NÂO");
        }

    }
}
