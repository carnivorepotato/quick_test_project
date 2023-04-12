package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AnagramChecker {

    public boolean checkIfTextsAreAnagrams(String first, String second) {
        if(trimAndCount(first) != trimAndCount(second)) {
            return false;
        }
        Pair firstPair = trimAndCountEachCharacter(first);
        Pair secondPair = trimAndCountEachCharacter(second);

        return firstPair.equals(secondPair);
    }

    private Pair trimAndCountEachCharacter(String text) {
        Map<Character, Long> resultMap = new HashMap<>();
        String trimmedText = trim(text);
        Set<Character> characterSet = trimmedText.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        List<Character> characterList = trimmedText.chars().mapToObj(ch -> (char) ch).toList();

        characterList.forEach(character -> {
            Long letterCount = resultMap.get(character);
            resultMap.put(character, letterCount != null ? ++letterCount : 1L);
        });

        return new Pair(characterSet, resultMap);
    }

    private int trimAndCount(String text) {
        return trim(text).length();
    }

    private String trim(String text) {
        return text.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    private record Pair(Set<Character> left, Map<Character, Long> right) {

        public boolean equals(Pair pair) {
            return this.left.equals(pair.left()) && this.right().entrySet().stream().allMatch(entry ->
                    entry.getValue().equals(pair.right().get(entry.getKey())));
        }
    }
}
