package javacore.Vio.aula02;

import java.io.File;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {

        File file = new File("file.txt");
        try(java.io.FileWriter fw = new java.io.FileWriter(file)) {
            fw.write("O DevDojo é muito legal, é o melhor curso do Brasillll.\nContinuando.....\n");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
