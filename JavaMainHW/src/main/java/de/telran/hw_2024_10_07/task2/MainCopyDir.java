package de.telran.hw_2024_10_07.task2;

import de.telran.hw_2024_10_07.task1.MyFile;

import java.util.Scanner;

public class MainCopyDir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // path to a file for coping
        System.out.print("Enter path for file to copy: ");
        String src = scanner.nextLine();

        // name of copy file
        System.out.print("Name of copy: ");
        String dest = scanner.nextLine();

        MyDir myDir = new MyDir();
        boolean res = myDir.copy(src, dest);
        System.out.println("Is file copied: " + res);
    }
}
