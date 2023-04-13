package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramChecker {

    public boolean checkIfTextsAreAnagrams(String first, String second) {
        if(getTrimmedLowercaseText(first).length() != getTrimmedLowercaseText(second).length()) {
            return false;
        }
        Map<Character, Long> firstTextMap = countCharacters(first);
        Map<Character, Long> secondTextMap = countCharacters(second);

        return firstTextMap.keySet().equals(secondTextMap.keySet()) &&
                firstTextMap.entrySet().stream().allMatch(entry ->
                entry.getValue().equals(secondTextMap.get(entry.getKey())));
    }

    private Map<Character, Long> countCharacters(String text) {
        Map<Character, Long> resultMap = new HashMap<>();
        String trimmedText = getTrimmedLowercaseText(text);
        List<Character> characterList = trimmedText.chars().mapToObj(ch -> (char) ch).toList();

        characterList.forEach(character -> {
            Long letterCount = resultMap.get(character);
            resultMap.put(character, letterCount != null ? ++letterCount : 1L);
        });

        return resultMap;
    }
    private String getTrimmedLowercaseText(String text) {
        return text.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
    }
}
