package javacore.Oexception.aula05.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest05 {
    public static void main(String[] args) throws IOException{

        criarNovoArquivo();
    }

    public static void criarNovoArquivo() throws IOException {
        File file = new File("arquivo/test.txt");
        try {
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado " + isCriado);
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Criando a obrigatoriedade de quem irá chamar o método, também deverá tratar a exception.
        }
    }
}
