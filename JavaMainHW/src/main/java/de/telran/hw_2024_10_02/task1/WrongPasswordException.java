package de.telran.hw_2024_10_02.task1;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super("Password is wrong!");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
