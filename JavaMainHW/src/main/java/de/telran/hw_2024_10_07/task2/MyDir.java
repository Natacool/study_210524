package de.telran.hw_2024_10_07.task2;

import de.telran.hw_2024_10_07.task1.MyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class MyDir {
    public MyDir() {
    }

    public boolean copy(String src, String dest){
        boolean res = false;

        if (src == null || dest == null){
            System.out.println("Error: source/destination can't be null.");
            return false;
        }

        if (src.equals(dest)){
            System.out.println("Error: Can't copy to itself.");
            return false;
        }

        File srcEntry = new File(src);
        if (!srcEntry.exists()){
            System.out.println("Error: source directory does NOT exist.");
            return false;
        }

        if (!srcEntry.isDirectory()){
            System.out.println("Error: source is NOT directory.");
            return false;
        }

        File destEntry = new File(dest);
        if (destEntry.exists()){
            System.out.println("Error: destination directory exist.");
            return false;
        } else {
            destEntry.mkdir(); // catch exception
        }

        File[] files = srcEntry.listFiles();
        res = true;
        if (files != null) {
            for (File f : files) {
                String entryName = f.getName();

                if (f.isDirectory()) {
                    copy(src + File.separator + entryName, dest + File.separator + entryName); // check res
                } else if (f.isFile()) {
                    MyFile myFile = new MyFile();
                    myFile.copy(src + File.separator + entryName, dest + File.separator + entryName); // check res
                } else {
                    System.out.println(f.getName() + " is NOT a file or a directory!");
                }
            }
        }


/*

        boolean res = false;

        if (src == null || dest == null){
            System.out.println("Error: source/destination can't be empty.");
            return false;
        }

        if (src.equals(dest)){
            System.out.println("Error: Can't copy to itself.");
            return false;
        }

        // Открываем файлы для копирования
        File sourceFile = new File(src);
        File destinationFile = new File(dest);

        // Проверяем, существует ли исходный файл
        if (!sourceFile.exists()) {
            System.out.println("Файл " + src + " не существует.");
            return false;
        }

        // Копируем содержимое
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int length;

            // Чтение и запись данных
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            System.out.println("Файл успешно скопирован.");
            res = true;

        } catch (IOException e) {
            System.out.println("Произошла ошибка при копировании файла: " + e.getMessage());
            res = false;
        }

*/


        return res;
    }
}
