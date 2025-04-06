package javacore.Vio.aula04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteTest01 {
    public static void main(String[] args) {

        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("O DevDojo é muito legal, é o melhor curso do Brasillll.");
            bw.newLine();
            bw.write("Utilizando quebra de linha com o newLine ao invés do \\n");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
