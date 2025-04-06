package javacore.Vio.aula05.exercicio;

import java.io.*;

public class ExerciceBufferedReaderTest01 {
    public static void main(String[] args) {

        File file = new File("novoDiario.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            System.out.println("\uD83D\uDCD6 --- Leitura do Diário --- \n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("\n✅ Fim da leitura do diário.");
        } catch (IOException e) {
            System.out.println("❌ Erro ao ler o diário.");
            e.printStackTrace();
        }

    }
}
