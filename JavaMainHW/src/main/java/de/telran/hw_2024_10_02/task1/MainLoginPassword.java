package de.telran.hw_2024_10_02.task1;

import java.util.List;
import java.util.Scanner;

public class MainLoginPassword {
    public static void main(String[] args) {

        boolean res = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Введите login: ");
            String login = scanner.nextLine();
            System.out.println("Введите password: ");
            String password = scanner.nextLine();
            System.out.println("Введите confirmPassword: ");
            String confirmPassword = scanner.nextLine();

            try {
                res = LoginPassword.verify(login, password, confirmPassword);
            } catch (WrongLoginException | WrongPasswordException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!res);
        System.out.println("login and password are OK");

    }
}
