package de.telran.hw_2024_10_07.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFile {
    public MyFile() {
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

        // from class work
        // Открываем файлы для копирования
        File sourceFile = new File(src);
        File destinationFile = new File(dest);

        // Проверяем, существует ли исходный файл
        if (!sourceFile.exists()) {
            System.out.println("File " + src + " does NOT exists.");
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

            System.out.println("File has been copied.");
            res = true;

        } catch (IOException e) {
            System.out.println("Error: exception during copying: " + e.getMessage());
            res = false;
        }
        return res;
    }
}
