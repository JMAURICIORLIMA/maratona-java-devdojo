package javacore.MInterfaces.aula01.test;

import javacore.MInterfaces.aula01.DatabaseLoader;
import javacore.MInterfaces.aula01.FileLoader;
import javacore.MInterfaces.aula01.domain.DatabaseLoader;
import javacore.MInterfaces.aula01.domain.FileLoader;

public class DataLoaderTeste01 {
    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        FileLoader fileLoader = new FileLoader();
        databaseLoader.load();
        fileLoader.load();
    }
}
