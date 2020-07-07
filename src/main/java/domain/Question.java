package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private String sentence;
    private List<String> keyWordsInAQuestion;

    public Question(String sentence) {
        this.sentence = sentence;
        this.keyWordsInAQuestion = getKeyWordsInAQuestion();
    }

    public String getSentence() {
        return sentence;
    }

    public List<String> getKeyWordsInAQuestion() {
        try {
            List stopwords = Files.readAllLines(Paths.get("src/main/resources/english_stop_words.txt"));
            return Arrays.asList(sentence
                    .split(" "))
                    .stream()
                    .filter(word -> !stopwords.contains(word.toLowerCase()))
                    .map(word -> word.replace("?", ""))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
