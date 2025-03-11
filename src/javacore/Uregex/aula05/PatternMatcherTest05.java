package javacore.Uregex.aula05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
    public static void main(String[] args) {

        /*
        * \d = Todos os dígitos (números)
        * \D = Tudo que nao for dígito, inclusive caracteres especiais.
        * \s = Todos os espaços em branco \t \n \f \r
        * \S = Tpdps ps caracteres excçuindo os brancos.
        * \w = a-Z, A-Z, digitos, _
        * \W = Tudp que não for incluso no \w
        * [] = Range
        * ? Zero ou uma ocorrencia
        * * zero ou mais ocorrencias
        * + uma ou mais ocorrencias
        * {n,m} ocorrencias que vão de n até m.
        * () agrupamento
        * | ou
        * $ fim da linha
        * . Caractere "coringa" 1.3, 123, 1@3, 1A3
         */

        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String text = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakira@mail";

        System.out.println("Email válido? " + "#@!zoro@mail.br".matches(regex)); // False
        System.out.println("Email válido? " + "zoro@mail.br".matches(regex)); // True

        System.out.println(text.split(",")[1].trim());

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Texto:   " + text);
        System.out.println("Indice:  0123456789");
        System.out.println("Regex  " + regex);
        System.out.println("Posições encontradas");

        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n"); // para saber o quw foi encontrado metcher.group()
        }
    }
}
