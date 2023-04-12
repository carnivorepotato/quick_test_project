package org.example;

public class Main {

    private static final AnagramChecker anagramChecker = new AnagramChecker();
    private static final String firstText = "An anagram is a word or phrase formed by rearranging the letters of a " +
            "different word or phrase, typically using all the original letters exactly once.";
    private static final String secondText = "HANDWRINGERS PARAMO OAR AAS FINGERBOARD MANGY ERR FORETEETH ATLS " +
            "WEATHERPROOFS FIRN REDD PUGNACITY YILL ALLS THERIOLATRIES GLENT ONYX ECCE ALT";
    private static final String thirdText = "HANDWRINGERS PARAMO OAR AAS FINGERBOARD MANGY ERR FORETEETH ATLS " +
            "WEATHERPROOFS FIRN REDD PUGNACITY YILL ALLS THERIOLATRIES GEENT ONYX ECCE ALT";

    public static void main(String[] args) {
        System.out.println(anagramChecker.checkIfTextsAreAnagrams(firstText, secondText));
        System.out.println(anagramChecker.checkIfTextsAreAnagrams(firstText, thirdText));
    }
}