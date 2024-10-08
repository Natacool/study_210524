package de.telran.hw_2024_10_01.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainLetterFrequencyGlossary {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        LetterFrequencyGlossary gl = new LetterFrequencyGlossary();
        gl.printGlossary('k');
        gl.printGlossary();

        gl.analyzeText("Mama mila ramu !!");
        gl.printGlossary('a');
        gl.printGlossary('e');
        gl.printGlossary('m');
        gl.printGlossary();

        gl.reset();
        gl.printGlossary('a');
        gl.printGlossary('e');
        gl.printGlossary('m');
        gl.printGlossary();

        gl.analyzeText("Mama mila ramu !!");
        gl.printGlossary('a');
        gl.printGlossary('e');
        gl.printGlossary('m');
        gl.printGlossary();
        gl.printGlossary('!');

        List<String> text = Arrays.asList("Mama", "mila", "ramu,", "snova!");
        gl.reset();
        gl.analyzeText(text);
        gl.printGlossary();


    }
}
