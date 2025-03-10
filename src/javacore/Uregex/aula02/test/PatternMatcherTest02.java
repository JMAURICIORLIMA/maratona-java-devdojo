package javacore.Uregex.aula02.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {

        /*
        * \d = Todos os dígitos (números)
        * \D = Tudo que nao for dígito, inclusive caracteres especiais.
        * \s = Todos os espaços em branco \t \n \f \r
        * \S = Tpdps ps caracteres excçuindo os brancos.
        * \w = a-Z, A-Z, digitos, _
        * \W = Tudp que não for incluso no \w
         */
        String regex = "\\W";
//        String text = "abaaba";
        String text2 = "@#$a3_jsf3 t 4sdfmaa6 4075";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text2);

        System.out.println("Texto:   " + text2);
        System.out.println("Indice:  0123456789");
        System.out.println("Regex  " + regex);
        System.out.println("Posições encontradas");

        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n"); // para saber o quw foi encontrado metcher.group()
        }
    }
}
