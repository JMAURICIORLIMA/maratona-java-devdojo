package javacore.Npolimorfismo.aula05.service;

import javacore.Npolimorfismo.aula05.repositorio.Repositorio;

public class RepositorioMemoria implements Repositorio {

    @Override
    public void salvar() {
        System.out.println("Salvando na memória");
    }
}
