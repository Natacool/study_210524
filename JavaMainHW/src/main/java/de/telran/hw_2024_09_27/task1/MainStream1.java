package de.telran.hw_2024_09_27.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream1 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("numbers: " + numbers);
//Задание 1: Фильтрация списка целых чисел на нечетные числа
        System.out.println("-----------------------------------------");
        System.out.println("Фильтрация списка целых чисел на нечетные числа");
        System.out.println("Odd: "
                + numbers
                .stream()
                .filter((val)-> val % 2 != 0)
                .toList());

//Задание 2: Преобразование списка строк в список чисел
        System.out.println("-----------------------------------------");
        System.out.println("Преобразовать список строк в список чисел");
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println("Str: " + strings);
        System.out.println("element type: "
                + strings
                .get(0)
                .getClass());

        List<Integer> integerList = strings
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Int: " + integerList);
        System.out.println("element type: "
                + integerList
                .get(0)
                .getClass());

//Задание 3: Суммирование списка чисел
        System.out.println("-----------------------------------------");
        System.out.println("Суммирование списка чисел");
        System.out.println("Sum: "
                + numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum());

//Задание 4: Определение максимального значения в списке
        System.out.println("-----------------------------------------");
        System.out.println("Определение максимального значения в списке");
        System.out.println("Max: "
                + numbers
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt());

//Задание 5: Фильтрация списка строк на те, которые начинаются с определенной буквы и преобразование их в верхний регистр
        System.out.println("-----------------------------------------");
        System.out.println("Фильтрация списка строк на те, которые начинаются с определенной буквы и преобразование их в верхний регистр");
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        System.out.println("List of words: " + words);
        //     * -- Отфильтровать строки на те которые начинаются на 'a' и преобразовать из в верхний регистр
        System.out.println("Words started with 'a' in UPPER case: "
                + words
                .stream()
                .filter(x -> x.startsWith("a"))
                .map(x -> x.toUpperCase())
                .toList());

//Задание 6: Получение списка уникальных слов из списка строк, длина которых больше 4 символов
        System.out.println("-----------------------------------------");
        System.out.println("Получение списка уникальных слов из списка строк, длина которых больше 4 символов");
        System.out.println("Words with length > 4: "
                + words
                .stream()
                .filter(x -> x.length()>4)
                .toList());

//Задание 7:Преобразование списка объектов класса в список их имен, отсортированных по возрасту ------
        System.out.println("-----------------------------------------");
        System.out.println("Преобразование списка объектов класса в список их имен, отсортированных по возрасту");
        class User {
            private String name;
            private int age;
            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }
            public String getName() {
                return name;
            }
            public int getAge() {
                return age;
            }

            @Override
            public String toString() {
                return "User{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }

        User u01 = new User("Alla", 24);
        User u02 = new User("Bella", 14);
        User u03 = new User("Nino", 23);
        User u04 = new User("Marat", 42);
        User u05 = new User("Ulrich", 56);
        User u06 = new User("Maria", 33);
        User u07 = new User("Fred", 25);
        User u08 = new User("Luis", 24);
        User u09 = new User("Margo", 16);
        User u10 = new User("John", 24);
        User u11 = new User("Samantha", 17);
        User u12 = new User("Ursula", 65);
        User u13 = new User("Ben", 30);
        List<User> users = new ArrayList<>();
        users.add(u01);
        users.add(u02);
        users.add(u03);
        users.add(u04);
        users.add(u05);
        users.add(u06);
        users.add(u07);
        users.add(u08);
        users.add(u09);
        users.add(u10);
        users.add(u11);
        users.add(u12);
        users.add(u13);
        System.out.println(users);
        System.out.println(users.stream().sorted().toList());

//Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел -------
        System.out.println("-----------------------------------------");
        System.out.println("Нахождение суммы чисел, кратных 3 и 5, из списка чисел");
        System.out.println("Multiple of 5: " + numbers
                .stream()
                .filter((val)-> val % 5 == 0)
                .toList());
        System.out.println("Sum of multiple of 5: "
                + numbers
                .stream()
                .filter((val)-> val % 5 == 0)
                .mapToInt(Integer::intValue)
                .sum());
        System.out.println("Multiple of 3: "
                + numbers
                .stream()
                .filter((val)-> val % 3 == 0)
                .toList());
        System.out.println("Sum of multiple of 3: "
                + numbers
                .stream()
                .filter((val)-> val % 3 == 0)
                .mapToInt(Integer::intValue)
                .sum());


//Задание 9:Получение списка слов, содержащих только уникальные символы, из списка строк
        System.out.println("-----------------------------------------");
        System.out.println("Получение списка слов, содержащих только уникальные символы, из списка строк");



//     * -- Получить среднее значение
        System.out.println("-----------------------------------------");
        System.out.println("Получить среднее значение");
        System.out.println("Average: "
                + numbers
                .stream()
                .mapToInt(Integer::intValue)
                .average());











        // Задача 1: Фильтрация четных чисел и умножение на 2.
        // Задача 2: Удаление дубликатов из списка строк.
        // Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех элементов.
        // Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний регистр.
        // Задача 5: Пропуск первых двух элементов и вывод оставшихся.
        // Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
        // Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном порядке.
        // Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания.
        // Задача 9: Получить среднее значение чисел в списке.
        // Задача 10: Получить строку, объединяющую элементы списка через запятую.
        // Задача 11: Получить список квадратов чисел из другого списка.
        // Задача 12: Получить список букв из списка слов и вывести их в алфавитном порядке.
        // Задача 13: Получить первые 3 строки из списка и вывести их в обратном порядке.
        // Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
        // Задача 15: Фильтрация и сортировка пользователей по возрасту.


    }
}
