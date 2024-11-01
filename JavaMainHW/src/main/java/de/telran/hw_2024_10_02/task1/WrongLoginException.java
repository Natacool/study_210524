package de.telran.hw_2024_10_02.task1;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException() {
        super("Login is incorrect!");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
