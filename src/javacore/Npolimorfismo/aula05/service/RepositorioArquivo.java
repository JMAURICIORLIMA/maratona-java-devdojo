package javacore.Npolimorfismo.aula05.service;

import javacore.Npolimorfismo.aula05.repositorio.Repositorio;

public class RepositorioArquivo implements Repositorio {
    @Override
    public void salvar() {
        System.out.println("Salvando em um arquivo");
    }
}
