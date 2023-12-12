package javacore.MInterfaces.aula02.test;

import javacore.MInterfaces.aula02.domain.DatabaseLoader;
import javacore.MInterfaces.aula02.domain.FileLoader;

public class DataLoaderTeste02 {
    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        FileLoader fileLoader = new FileLoader();
        databaseLoader.load();
        fileLoader.load();

        databaseLoader.remove();
        fileLoader.remove();

        databaseLoader.checkPermission();
        fileLoader.checkPermission();
    }
}
