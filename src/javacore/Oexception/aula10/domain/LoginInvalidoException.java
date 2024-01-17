package javacore.Oexception.aula10.domain;

public class LoginInvalidoException extends Exception {

    public LoginInvalidoException() {
        super("Login inválido");
    }

    public LoginInvalidoException(String message) {
        super(message);
    }
}
