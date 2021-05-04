package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FrequencyWords {
    public void countWords(String freqName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(freqName));
        List<String> list;
        String string;
        String[] result;

        while ((string = br.readLine()) != null) {
            string = string.replaceAll("[()?:!.,;{}]+", "").replaceAll("\\s+", " ").replaceAll("[1-9]", "").replaceAll("[\\n|\\u00A0]+", "");
            result = string.split(" ");
            for (int i = 0; i < result.length; i++)
                result[0] = result[i];
            Map<String, Integer> wordCount = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            list = Arrays.asList(result);
            Collections.sort(list);
            for (String word : (list)) {
                if (wordCount.containsKey(word) && word.length() > 2) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
            for (Map.Entry<String, Integer> word1 : wordCount.entrySet())
                if (word1.getValue().intValue() > 1) {
                    System.out.printf("word : %s count: %d \n", word1.getKey().toLowerCase(Locale.ROOT), word1.getValue());
                }
        }
    }
}
