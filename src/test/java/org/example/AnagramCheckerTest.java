package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnagramCheckerTest {

    private static final String firstText = "An anagram is a word or phrase formed by rearranging the letters of a " +
            "different word or phrase, typically using all the original letters exactly once.";
    private static final String secondText = "HANDWRINGERS PARAMO OAR AAS FINGERBOARD MANGY ERR FORETEETH ATLS " +
            "WEATHERPROOFS FIRN REDD PUGNACITY YILL ALLS THERIOLATRIES GLENT ONYX ECCE ALT";
    private static final String thirdText = "HANDWRINGERS PARAMO OAR AAS FINGERBOARD MANGY ERR FORETEETH ATLS " +
            "WEATHERPROOFS FIRN REDD PUGNACITY YILL ALLS THERIOLATRIES GLENT ONYX ECCE ALTOR";
    private static final String fourthText = "HANDWRINGERS PARAMO OAR AAS FINGERBOARD MANGY ERR FORETEETH ATLS " +
            "WEATHERPROOFS FIRN REDD PUGNACITY YILL ALLS THERIPPATRIES GLENT ONYX ECCE ALT";

    AnagramChecker subj;

    @BeforeEach
    void init() {
        this.subj = new AnagramChecker();
    }

    @Test
    void testCheckIfTextsAreAnagramsTrue() {
        assertTrue(subj.checkIfTextsAreAnagrams(firstText, secondText));
    }

    @Test
    void testCheckIfTextsAreAnagramsLengthNotEqual() {
        assertFalse(subj.checkIfTextsAreAnagrams(firstText, thirdText));
    }

    @Test
    void testCheckIfTextsAreAnagramsNotAnagram() {
        assertFalse(subj.checkIfTextsAreAnagrams(firstText, fourthText));
    }

}