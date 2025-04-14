package javacore.Vio.aula06;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) {

        File fileDiretorio = new File("folder");
        boolean isDiretorioCreated = fileDiretorio.mkdir();
        System.out.println("A pasta foi criada? " + isDiretorioCreated);
        // Passando o caminho absoluto
//        File fileDiretorioArquivo = new File("/home/jmauricio/IdeaProjects/maratona-java-devdojoe/folder/arquive.txt");

//        Passando a referência do objeto fileDiretorio.
        try {

            File fileArquivoDiretorio = new File(fileDiretorio, "arquivo.txt");

            boolean isFileCreated = fileArquivoDiretorio.createNewFile();
            System.out.println("O arquivo.txt foi criado? " + isFileCreated);

            File fileRenamed = new File(fileDiretorio, "arquivo_renomeado.txt");
            boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
            System.out.println("O arquivo.txt foi renomeado? " + isRenamed);

            File diretorioRenamed = new File("New_Folder");
            boolean isDireitorioRenamed = fileDiretorio.renameTo(diretorioRenamed);
            System.out.println("Diretorio da pasta foi renomeado? " + isDireitorioRenamed);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
