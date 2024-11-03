package de.telran.hw_2024_10_04.task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MainWordCounter {
    public static void main(String[] args) {
        //Разбить текст на слова с помощью шаблона регулярного выражения и расчитать
        //словарь встречающихся слов для этого текста
        //(подсчитать количество одинаковых слов, встречающихся в этом тексте).

        String text = "I,learned Java. I know something about.Telran !Colleagues and I now are studying Java!";
        System.out.println("Count words in folowing text:");
        System.out.println("'" + text +"'");
        String delimiter = "\\W+";//на слова

        Pattern pattern = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);
        String[] result = pattern.split(text);
        //System.out.println("res: " + Arrays.stream(result).toList());

        Map<String, Integer> dict = new HashMap<>();
        for (String val : result) {
            Integer i = dict.get(val);
            if (i == null){
                dict.put(val, 1);
            }
            else {
                dict.put(val, ++i);
            }
        }
        System.out.println(dict.toString());
    }
}
