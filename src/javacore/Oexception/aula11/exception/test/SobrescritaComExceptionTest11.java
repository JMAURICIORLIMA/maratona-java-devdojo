package javacore.Oexception.aula11.exception.test;

import javacore.Oexception.aula10.domain.LoginInvalidoException;
import javacore.Oexception.aula11.exception.domain.Funcionario;
import javacore.Oexception.aula11.exception.domain.Pessoa;

import java.io.FileNotFoundException;

public class SobrescritaComExceptionTest11 {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();



        try {
            funcionario.salvar();
        } catch (LoginInvalidoException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
