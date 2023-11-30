package javacore.Hheranca.test;

import javacore.Hheranca.dominio.Funcionario;

public class HerancaTest02 {

//    0 - Bloco de inicialização estático da super classe é executado quando a JVM carregar a classe pai
//    1 - Bloco de inicialização estático da sub classe é executado quando a JVM carregar a classe filha
//    2 - Aloca espaço em memória para o objeto da superclasse
//    3 - Cada atributo da superclasse é criado e inicializado com valores default ou o que for passaso da superclasse
//    4 - Bloco de inicialização da superclase é executado na ordem em que aparece
//    5 - O construtor da superclasse executado.
//    6 - Aloca espaço em memória para o objeto da subclasse
//    7 - Cada atributo da subclasse é criado e inicializado com valores default ou o que for passaso da subclasse
//    8 - Bloco de inicialização da subclasse é executado na ordem em que aparece
//    9 - O construtor da subclasse executado.

    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario("Jiraya");
    }
}
