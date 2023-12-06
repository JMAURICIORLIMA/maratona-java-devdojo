package javacore.Kenum.aula01.test;

import javacore.Kenum.aula01.dominio.Cliente;
import javacore.Kenum.aula01.dominio.TipoCliente;

public class ClienteTest01 {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Tsubasa", TipoCliente.PESSOA_FISICA);
        Cliente cliente2 = new Cliente("Kuririn", TipoCliente.PESSOA_FISICA);
        Cliente cliente3 = new Cliente("Jiraia", TipoCliente.PESSOA_FISICA);
        Cliente cliente4 = new Cliente("Sakura", TipoCliente.PESSOA_JURICICA);

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println(cliente4);

    }
}
