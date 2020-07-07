import domain.Answer;
import domain.AnswerToParagraph;
import domain.Paragraph;

import java.util.List;
import java.util.stream.Collectors;

public class ParagraphFilter {
    public static List<AnswerToParagraph> getLinesRelevantByAnswers(Paragraph paragraph, Answer answers) {
        return answers.getIndividualAnswer().stream().map(answer -> {
            List<String> probableLines = filterLinesWhichContainAnswer(paragraph, answer);
            return new AnswerToParagraph(answer.trim(), probableLines);
        }).collect(Collectors.toList());
    }

    private static List<String> filterLinesWhichContainAnswer(Paragraph paragraph, String answer) {
        return paragraph.getSentence()
                .getIndividualLines()
                .stream()
                .filter(sentence -> sentence.toLowerCase().contains(answer.toLowerCase()))
                .collect(Collectors.toList());
    }
}