package de.telran.hw_2024_10_01.task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterFrequencyGlossary {
    Map<Character, Integer> glossary;

    public LetterFrequencyGlossary() {
        this.glossary = new HashMap<Character, Integer>();
        initGlossary();
    }

    private void initGlossary(){
        for (int i='a'; i<='z'; i++){
            this.glossary.put((char)i, 0);
        }
        System.out.println("Glossary has been initialized with " + this.glossary.size() + " letters of English alphabet...");
    }

    public void printGlossary(char letter){
        char index = letter;
        int data = 0;
        System.out.println(letter + "=" + this.glossary.get(letter));
    }

    public void printGlossary(){
        System.out.println(this.glossary.toString());
    }

    public void analyzeText(List<String> text) {
        for (String data: text) {
            analyzeText(data);
        }
    }

    public void analyzeText(String text){
        String data = text.toLowerCase();

        for (char key: data.toCharArray()) {
            if (key >= 'a' && key <= 'z'){
                int val = this.glossary.get(key);
                val++;
                this.glossary.put(key,val);
            }
            else {
                //System.out.println("key:[" + key + "] is NOT a letter!");
            }
        }
        System.out.println("Text: [" + text + "] analyzed!");
    }

    public void reset(){
        System.out.println("Reset glossary");
        initGlossary();
    }
}
