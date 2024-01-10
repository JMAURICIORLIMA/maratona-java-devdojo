package javacore.Oexception.aula04.runtime.test;

public class RuntimeExceptionTest04 {
    public static void main(String[] args) {

        try {
            divisao(1, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println("Código finalizado...");

    }

    /**
     *
     * @param a
     * @param b Divisor não pode ser zero
     * @return
     * @throws IllegalArgumentException caso b seja zero.
     */
    private static int divisao(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Argumento ilegal, divisor não pode ser 0");
        }

        return a / b;

//      Bloco pode ser substituído pelo código acima.

//        try {
//            return a / b;
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
    }
}
