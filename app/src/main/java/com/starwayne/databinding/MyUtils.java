package com.starwayne.databinding;


import com.starwayne.databinding.bean.Person;

import java.util.Random;

public class MyUtils {
    private static Random sRandom =new Random(System.currentTimeMillis());

    public static String capitalizeFirstLetter(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }

    public static Person genNewPerson(){
        String name = MyUtils.getRandomName();
        String age = Integer.toBinaryString(MyUtils.getRandomAge(100));
        String country = MyUtils.getRandomCountry();
        return new Person(name, age, country);
    }

    public static String getRandomName(){
        String upLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowLetters = "abcdefghijklmnopqrstuvwxyz";

        int length = 0;
        while(length < 3){
            length = sRandom.nextInt(10);
        }
        StringBuffer sb=new StringBuffer();
        sb.append(upLetters.charAt(sRandom.nextInt(26)));
        for(int i=0; i<length - 1; ++i){
            sb.append(lowLetters.charAt(sRandom.nextInt(26)));
        }
        return sb.toString();
    }

    public static int getRandomAge(int maxAge){
        return sRandom.nextInt(maxAge);
    }

    public static String getRandomCountry(){
        String[] countries =new String[]{"China", "USA", "France", "England", "Russia"};
        return countries[sRandom.nextInt(5)];
    }
}
