package javacore.Qstring.aula01.test01;

public class StringTest01 {
    public static void main(String[] args) {

        String nome = "Maurício"; // String constant pool
        String nome2 = "Maurício";
        nome = nome.concat(" de Lima");
        System.out.println(nome);
        System.out.println(nome == nome2);
        String nome3 = new String("Maurício"); // 1 variavel de referência, 2 objeto do tipo String, 3 uma string no pool de String.
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());
    }
}
