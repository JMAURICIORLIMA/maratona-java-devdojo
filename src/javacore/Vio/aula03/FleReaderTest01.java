package javacore.Vio.aula03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FleReaderTest01 {
    public static void main(String[] args) {

        File file = new File("file.txt");
        try (FileReader fr = new FileReader(file)) {

//            char[] in = new char[70];
//            fr.read(in);
//            for (char c : in) {
//                System.out.print(c);
//            }

            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }

            fr.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
