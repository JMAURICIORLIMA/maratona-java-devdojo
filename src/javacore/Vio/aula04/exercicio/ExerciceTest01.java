package javacore.Vio.aula04.exercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExerciceTest01 {
    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fraseParaDiario = "Na primeira interação, o campo referente a data e a hora foi escrito sem formatação" +
                ", no segundo momento, estava tudo agarrado, e a partir do terceiro momento, tudo está saindo conforme" +
                "o esperado.";
        String dataFormatada = ldt.format(dtf);

        try (FileWriter fw = new FileWriter("diario.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("[" + dataFormatada + "] - " + fraseParaDiario);
            bw.newLine();
            bw.flush();
            System.out.println("Entrada adicionada ao diário");
        } catch (IOException e) {
            System.out.println("Algo deu errado.");
            e.printStackTrace();
        }
    }
}
