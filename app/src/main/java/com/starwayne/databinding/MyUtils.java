package com.starwayne.databinding;


public class MyUtils {
    public static String capitalizeFirstLetter(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }
}
