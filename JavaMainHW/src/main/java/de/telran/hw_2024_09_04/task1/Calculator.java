package de.telran.hw_2024_09_04.task1;

public interface Calculator<T extends Number> {
    public T add (T d1, T d2);
    public T sub (T d1, T d2);
    public T mul (T d1, T d2);
    public T div (T d1, T d2);
}
