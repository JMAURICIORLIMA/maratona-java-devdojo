package javacore.Oexception.aula09.exception.test;

import javacore.Oexception.aula09.exception.domain.Leitor1;
import javacore.Oexception.aula09.exception.domain.Leitor2;

import java.io.*;

public class TrayWithResourcesTest09 {
    public static void main(String[] args) {

        lerArquivo();

    }

    public static void lerArquivo() {
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2()) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerArquivo2() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
