package de.telran.hw_2024_10_04.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainCheckEmail {
    public static void main(String[] args) {
        // my_25@domen-38.de

        String email = new String("mymm_25@domen-38.de");
        String email1 = new String("11_9-m1.m1@do_men.jde");
        String email2 = new String("a_b-1c.m-.nd@dom._enj.skde");
        String regEx = "^([\\w\\.\\d\\-\\_]+)@([\\w\\d\\-\\_\\.]+).([\\w]+)";

        Pattern pattern = Pattern.compile(regEx);//, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        System.out.println("find -> "+matcher.find());
        System.out.println("matches -> "+matcher.matches());

    }
}
