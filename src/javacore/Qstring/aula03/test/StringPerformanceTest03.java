package javacore.Qstring.aula03.test;

public class StringPerformanceTest03 {

    public static void main(String[] args) {
        int interacoes = 100_000;

        long inicio = System.currentTimeMillis();
        concatString(interacoes);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para String " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        concatStringBilder(interacoes);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuilder " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        concatStringBuffer(interacoes);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuffer " + (fim - inicio) + " ms");

    }
    private static void concatString(int tamanho) {
        String texto = "";

        for (int i = 0; i < tamanho; i++) {
            texto += i;
        }
    }

    private static void concatStringBilder(int tamanho) {
        StringBuilder stringBuilder = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(i);
        }
    }

    private static void concatStringBuffer(int tamanho) {
        StringBuffer stringBuffer = new StringBuffer(tamanho);

        for (int i = 0; i < tamanho; i++) {
            stringBuffer.append(i);
        }
    }
}
