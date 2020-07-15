package com.wiki.utilities;

import com.wiki.domain.InputRequest;
import com.wiki.domain.Question;
import com.wiki.domain.Sentence;
import com.wiki.validation.InputValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToInputRequestBuilder {
    public static InputRequest build(String filePath) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            List<String> lines = stream.collect(Collectors.toList());
            InputValidator inputValidator = new InputValidator();
            inputValidator.validate(lines);
            return InputRequest.builder()
                    .withParagraph(new Sentence(lines.get(0), "\\."))
                    .withQuestions(buildQuestions(lines))
                    .withAnswers(buildAnswers(lines))
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return InputRequest.builder().build();
    }

    private static List<String> buildAnswers(List<String> lines) {
        Sentence sentence = new Sentence(lines.get(6), ";");
        return sentence.getIndividualLines();
    }

    private static List<Question> buildQuestions(List<String> lines) {
        return lines.subList(1, 6)
                .stream()
                .map(Question::new)
                .collect(Collectors.toList());
    }
}
