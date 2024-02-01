package javacore.Qstring.aule02.test;

public class StringTest02 {

    public static void main(String[] args) {

        String nome = "Luffy";
        String numeros = "012345";
        System.out.println(nome.charAt(0)); // Retorna o caractere respectivo a posição
        System.out.println(nome.length()); // Retorna o tamanho da string
        System.out.println(nome.replace("f","l")); // Substitui caracteres informados por outro que queira que seja substituido
        System.out.println(nome.toLowerCase()); // Converte tudo para caixa baixa
        System.out.println(nome.toUpperCase()); // Converte tudo para caixa alta
        System.out.println(numeros.length());
        System.out.println(numeros.substring(3, numeros.length())); // Retorna um range de string determinado
        System.out.println(nome.trim()); // Retira todos os espaçamentos da string
    }
}
