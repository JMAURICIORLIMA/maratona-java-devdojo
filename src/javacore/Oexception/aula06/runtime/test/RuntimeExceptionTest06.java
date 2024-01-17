package javacore.Oexception.aula06.runtime.test;

public class RuntimeExceptionTest06 {
    public static void main(String[] args) {

        abreConexao2();
    }

    private static String abreConexao() {
        try {
            System.out.println("Abrindo conexão");
            System.out.println("Escrevendo dados no arquivo");
            return "Conexão aberta";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fechando recurso liberado pelo SO");
        }
        return null;
    }

    private static void abreConexao2() {
        try {
            System.out.println("Abrindo conexão");
            System.out.println("Escrevendo dados no arquivo");
            throw new RuntimeException();
        } finally {
            System.out.println("Fechando recurso liberado pelo SO");
        }
    }
}
