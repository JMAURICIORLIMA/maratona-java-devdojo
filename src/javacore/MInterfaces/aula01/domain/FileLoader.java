package javacore.MInterfaces.aula01.domain;

public class FileLoader implements javacore.MInterfaces.aula01.domain.DataLoader {
    @Override
    public void load() {
        System.out.println("Carregando dados de um arquivo");
    }
}
