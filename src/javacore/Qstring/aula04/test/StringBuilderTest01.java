package javacore.Qstring.aula04.test;

public class StringBuilderTest01 {

    public static void main(String[] args) {

        String nome = "William Suane";
        nome.concat(" DevDojo");
        System.out.println(nome);

        StringBuilder sb = new StringBuilder("William Suane");
        sb.append(" DevDojo").append(" Academy"); // Concatenação do StringBuilder
        System.out.println(sb);
        sb.reverse(); // Inverte toda cadeia de caracteres armazenada
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.delete(0,3); // Deleta no intervalo desejado, sendo o segundo valor -1.
        System.out.println(sb);
    }
}
