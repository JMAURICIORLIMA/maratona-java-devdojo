package javacore.Uregex.aula07;

public class ScannerTest01 {

    public static void main(String[] args) {

        String text = "Levi, Eren, Mikasa";
        String[] nomes = text.split(",");

        for (String nome : nomes) {
            System.out.println(nome.trim());
        }

    }
}
