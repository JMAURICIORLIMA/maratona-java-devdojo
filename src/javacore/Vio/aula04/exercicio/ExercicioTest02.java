package javacore.Vio.aula04.exercicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class ExercicioTest02 {
    public static void main(String[] args) {

        String[] frasesMotivacionais = {
                "O primeiro passo, por menor que seja, te leva mais perto do seu objetivo.",
                "Acredite no seu potencial e comece agora. O futuro recompensa a ação.",
                "Transforme seus sonhos em metas e suas metas em realidade, um dia de cada vez.",
                "Não espere pela perfeição, faça o seu melhor com o que você tem hoje.",
                "Cada dia é uma nova oportunidade de fazer diferente e melhor.",
                "Pequenos progressos diários levam a resultados extraordinários.",
                "A persistência realiza o impossível.",
                "Se você pode sonhar, você pode realizar. Comece hoje!",
                "O sucesso nasce da decisão de nunca desistir.",
                "Mantenha o foco no seu objetivo, mesmo que o caminho pareça longo.",
                "Acredite no seu potencial e comece agora. O futuro recompensa a ação.",
                "Transforme seus sonhos em metas e suas metas em realidade, um dia de cada vez.",
                "Não espere pela perfeição, faça o seu melhor com o que você tem hoje.",
                "Cada dia é uma nova oportunidade de fazer diferente e melhor.",
                "Pequenos progressos diários levam a resultados extraordinários.",
                "A persistência realiza o impossível.",
                "Se você pode sonhar, você pode realizar. Comece hoje!",
                "O sucesso nasce da decisão de nunca desistir.",
                "Mantenha o foco no seu objetivo, mesmo que o caminho pareça longo."
        };

        Random ramdom = new Random();
        String fraseSorteada = frasesMotivacionais[ramdom.nextInt(frasesMotivacionais.length)];

        System.out.println("Frase do Dia: " + fraseSorteada);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escreva sua reflexão de hoje: " );
        String reflexao = scanner.nextLine();

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = ldt.format(dtf);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("novoDiario.txt"))){
            bw.write("\uD83D\uDCC5 [" + dataHoraFormatada + "]");
            bw.newLine();
            bw.write("\uD83D\uDCAD " + fraseSorteada);
            bw.newLine();
            bw.write("\uD83D\uDCDD Reflexão: " + reflexao);
            bw.newLine();
            bw.write("----------------------------------------------------------------------");
            bw.newLine();
            bw.flush();
            System.out.println("\n✅ Entrada adicionada com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
