package javacore.Pwrapper.aula02.test;

public class WrapperTest02 {

    public static void main(String[] args) {
        // Regra de tamanho ocupado em memória
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 10L;
        float floatP = 10F;
        double doubleP = 10D;
        char charP = 'W';
        boolean booleanP = false;

        // Regra de polimorfismo
        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1; // autoboxing (Conversão de um tipo primitivo para uma classa Wrapper)
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Character charW = 'W';
        Boolean booleanW = false;

        int i = intW; // unboxing (Conversão de um tipo Wrapper para um tipo primitivo)
        Integer intW2 = Integer.parseInt("1");
        boolean verdadeiro = Boolean.parseBoolean("TruE");

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('A'));
    }
}
