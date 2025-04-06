package javacore.Vio.aula04.exercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class ExercicioTest02 {
    public static void main(String[] args) {

        String[] frasesMotivacionais = {
//                Foco e Ação:
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

//                Crescimento e Aprendizado:
                "Acredite no seu potencial e comece agora. O futuro recompensa a ação.",
                "Transforme seus sonhos em metas e suas metas em realidade, um dia de cada vez.",
                "Não espere pela perfeição, faça o seu melhor com o que você tem hoje.",
                "Cada dia é uma nova oportunidade de fazer diferente e melhor.",
                "Pequenos progressos diários levam a resultados extraordinários.",
                "A persistência realiza o impossível.",
                "Se você pode sonhar, você pode realizar. Comece hoje!",
                "O sucesso nasce da decisão de nunca desistir.",
                "Mantenha o foco no seu objetivo, mesmo que o caminho pareça longo.",

//                Mentalidade Positiva e Resiliência:
                "Acredite em si mesmo, mesmo quando os outros duvidarem.",
                "Seja a energia positiva que você deseja atrair.",
                "Os desafios de hoje são as conquistas de amanhã.",
                "A vida é feita de recomeços. Não tenha medo de tentar novamente.",
                "Agradeça pelo presente, aprenda com o passado e construa o futuro.",
                "Sua atitude determina sua direção.",
                "A força não vem de vencer. Suas lutas desenvolvem suas forças.",
                "Encare os obstáculos como oportunidades de crescimento.",
                "A felicidade não é um destino, é uma jornada. Aproveite cada momento.",
                "Cultive a gratidão e veja o mundo com mais positividade.",

//                Bem-estar e Autocuidado:
                "Cuide da sua mente, do seu corpo e da sua alma. Você merece!",
                "Reserve um tempo para você, para recarregar as energias.",
                "Priorize sua saúde, ela é o seu bem mais precioso.",
                "Acalme sua mente, respire fundo e siga em frente.",
                "Seja gentil com você mesmo, você está fazendo o seu melhor.",
                "Encontre alegria nas pequenas coisas do dia a dia.",
                "Conecte-se com pessoas que te inspiram e te fazem bem.",
                "Permita-se descansar e recarregar as energias.",
                "Celebre suas conquistas, por menores que sejam.",
                "Viva o presente intensamente, ele é um presente.",

//                Para Inspirar Outros:
                "Seja a mudança que você deseja ver no mundo.",
                "Sua luz pode inspirar muitas outras pessoas.",
                "Compartilhe sua paixão e motive aqueles ao seu redor.",
                "Pequenos atos de bondade podem fazer uma grande diferença.",
                "A união faz a força. Juntos somos mais fortes."
        };

        Random ramdom = new Random();
        String fraseSorteada = frasesMotivacionais[ramdom.nextInt(frasesMotivacionais.length)];

        System.out.println("Frase do Dia: " + fraseSorteada);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escreva sua reflexão de hoje: ");
        String reflexao = scanner.nextLine();

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = ldt.format(dtf);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("novoDiario.txt", true))) {
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
