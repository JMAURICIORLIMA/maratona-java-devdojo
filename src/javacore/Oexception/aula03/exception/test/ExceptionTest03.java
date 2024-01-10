package javacore.Oexception.aula03.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest03 {
    public static void main(String[] args) {

        // Ao restingir a criação de arquivos, o mesmo lançará a exceção mostrada em vídeo.
        criarNovoArquivo();
    }

    private static void criarNovoArquivo() {
        File file = new File("arquivo/test.txt");
        try {
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado " + isCriado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
