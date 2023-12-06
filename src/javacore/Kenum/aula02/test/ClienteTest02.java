package javacore.Kenum.aula02.test;

import javacore.Kenum.aula02.dominio.Cliente;
import javacore.Kenum.aula02.dominio.TipoCliente;

import static javacore.Kenum.aula02.dominio.Cliente.*;

public class ClienteTest02 {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Tsubasa", TipoCliente.PESSOA_FISICA, TipoPagamento.CREDITO);
        Cliente cliente2 = new Cliente("Akira", TipoCliente.PESSOA_JURIDICA, TipoPagamento.DEBITO);

        System.out.println(cliente1);
        System.out.println(cliente2);

    }
}
