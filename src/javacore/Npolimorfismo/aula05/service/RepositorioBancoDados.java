package javacore.Npolimorfismo.aula05.service;

import javacore.Npolimorfismo.aula05.repositorio.Repositorio;

public class RepositorioBancoDados implements Repositorio {
    @Override
    public void salvar() {
        System.out.println("Salvando no Banco de dados");
    }
}
