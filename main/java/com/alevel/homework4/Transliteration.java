package com.alevel.homework4;

import java.util.Scanner;

public class Transliteration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What Cyrillic text should be transliterated? (The number of characters must be no more than 30 characters):");
        String s = in.nextLine();

        String trancatedText = trancateText(s);

        System.out.println(transliterateString(trancatedText));
    }

    static String convertSymbol(String symbol) {
        switch (symbol) {
            case "а":
                return "a";
            case "б":
                return "b";
            case "в":
                return "v";
            case "г":
                return "g";
            case "д":
                return "d";
            case "е":
                return "je";
            case "ё":
                return "jo";
            case "ж":
                return "ž";
            case "з":
                return "z";
            case "и":
                return "i";
            case "й":
                return "y";
            case "к":
                return "k";
            case "л":
                return "l";
            case "м":
                return "m";
            case "н":
                return "n";
            case "о":
                return "o";
            case "п":
                return "p";
            case "р":
                return "r";
            case "с":
                return "s";
            case "т":
                return "t";
            case "у":
                return "u";
            case "ф":
                return "f";
            case "х":
                return "h";
            case "ц":
                return "c";
            case "ч":
                return "ch";
            case "ш":
                return "sh";
            case "щ":
                return "sch";
            case "ъ":
                return "`";
            case "ы":
                return "y";
            case "ь":
                return "j";
            case "э":
                return "e";
            case "ю":
                return "ju";
            case "я":
                return "ya";
            case " ":
                return " ";
            default:
                return "";
        }
    }
    
    static String transliterateString (String text) {
        String[] splittedText = text.split("");
        String transliteratedText = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                String symbol = convertSymbol(splittedText[i].toLowerCase());
                transliteratedText = transliteratedText + symbol.toUpperCase();
            } else {
                transliteratedText = transliteratedText + convertSymbol(splittedText[i]);
            };
        }
        return transliteratedText;
    }

    static String trancateText(String text) {
        String result;
        if (text.length() <= 30) {
            System.out.println("Length of text is right. Start transliteration...");
            result = text;
        } else {
            System.out.println("The entered text will be truncated to 30 characters.");
            result = text.substring(0, 30);
        }
        return result;
    }
}