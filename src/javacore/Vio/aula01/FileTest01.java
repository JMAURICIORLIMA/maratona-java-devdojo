package javacore.Vio.aula01;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

public class FileTest01 {
    public static void main(String[] args) {

        File file = new File("/home/jmauricio/IdeaProjects/maratona-java-devdojoe/arquivo/.file.txt");

        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created: " + isCreated);
            System.out.println("path: " + file.getPath());
            System.out.println("path absolute: " + file.getAbsolutePath());
            System.out.println("is directory: " + file.isDirectory());
            System.out.println("is file: " + file.isFile());
            System.out.println("is hidden: " + file.isHidden()); // Oculto.
            System.out.println("last modified: " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()));

            boolean exists = file.exists();
            if (exists) {
                boolean deleted = file.delete();
                System.out.println("Deleted: " + deleted);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
