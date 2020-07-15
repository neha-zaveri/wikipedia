package com.wiki.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private String sentence;

    public Question(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public List<String> getKeyWordsInAQuestion() {
        try {
            List stopwords = Files.readAllLines(Paths.get("src/main/resources/words_to_exclude.txt"));
            return Arrays.stream(sentence
                    .split(" "))
                    .filter(word -> !stopwords.contains(word.toLowerCase()))
                    .map(word -> word.replace("?", ""))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
