package de.telran.hw_2024_10_02.task1;

public class LoginPassword {
    public static boolean verify(String login, String password, String confirmPassword){
        return verifyLogin(login) && verifyPassword(password, confirmPassword);
    }

    private static boolean verifyLogin(String login)
    {
        if (!LoginPassword.isLength(login, 20)){
            throw new WrongLoginException("Login length should be < 20");
        }

        if (login.length() == 0)
        {
            throw new WrongLoginException();
        }

        if (!LoginPassword.isLatinSmb(login.charAt(0))){
            throw new WrongLoginException("Login should start with latin letter");
        }

        if (login.length() > 1)
        {
            char[] symbols = login.toCharArray();
            for (int i = 1; i < symbols.length; i++) {
                if (!LoginPassword.isDigit(symbols[i])
                        && !LoginPassword.isLatinSmb(symbols[i])
                        && !LoginPassword.isUnderscore(symbols[i]))
                {
                    throw new WrongLoginException("Login should contain 'latin letters', 'digits','underscore'.");
                }
            }
        }

        return true;
    }

    private static boolean verifyPassword(String password, String confirmPassword)
    {

        if (!LoginPassword.equalPasswords(password, confirmPassword)){
            throw new WrongPasswordException("Password and confirmPassword are not equal!");
        }

        if (!LoginPassword.isLength(password, 20)){
            throw new WrongPasswordException("Password length should be < 20!");
        }

        if (password.length() == 0)
        {
            throw new WrongPasswordException();
        }

        if (password.length() > 1)
        {
            char[] symbols = password.toCharArray();
            for (int i = 1; i < symbols.length; i++) {
                if (!LoginPassword.isDigit(symbols[i])
                        && !LoginPassword.isLatinSmb(symbols[i]))
                {
                    throw new WrongPasswordException("Password should contain 'latin letters', 'digits'!");
                }
            }
        }
        return true;
    }

    public static boolean isLength(String str, int maxLength){
        return str.length() <= maxLength;
    }

    public static boolean isDigit(char smb){
        return smb >= '0' && smb <= '9';
    }

    public static boolean isUnderscore(char smb){
        return smb == '_';
    }

    public static boolean isLatinSmb(char smb){
        return smb >= 'A' && smb <= 'z';
    }

    public static boolean equalPasswords(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

}
