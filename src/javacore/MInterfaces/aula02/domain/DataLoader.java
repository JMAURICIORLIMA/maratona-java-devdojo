package javacore.MInterfaces.aula02.domain;

public interface DataLoader {

    void load();
    default void checkPermission(){
        System.out.println("Fazendo checagem de permissões");
    }
}
