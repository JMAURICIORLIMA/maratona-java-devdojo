package javacore.MInterfaces.aula03.test;

import javacore.MInterfaces.aula03.domain.DataLoader;
import javacore.MInterfaces.aula03.domain.DatabaseLoader;
import javacore.MInterfaces.aula03.domain.FileLoader;

public class DataLoaderTeste03 {
    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        FileLoader fileLoader = new FileLoader();
        databaseLoader.load();
        fileLoader.load();

        databaseLoader.remove();
        fileLoader.remove();

        databaseLoader.checkPermission();
        fileLoader.checkPermission();

        DataLoader.retrieveMaxDataSize();
        DatabaseLoader.retrieveMaxDataSize();
    }
}
