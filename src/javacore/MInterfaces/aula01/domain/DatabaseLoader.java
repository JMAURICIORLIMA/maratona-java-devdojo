package javacore.MInterfaces.aula01.domain;

public class DatabaseLoader implements javacore.MInterfaces.aula01.domain.DataLoader {
    @Override
    public void load() {
        System.out.println("Carregando dados do banco de dados");
    }
}
