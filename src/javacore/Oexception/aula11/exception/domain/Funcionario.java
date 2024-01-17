package javacore.Oexception.aula11.exception.domain;

import javacore.Oexception.aula10.domain.LoginInvalidoException;

import java.io.FileNotFoundException;

public class Funcionario extends Pessoa {
    @Override
    public void salvar() throws LoginInvalidoException, FileNotFoundException {
        System.out.println("Salvando funcionário");
    }
}
