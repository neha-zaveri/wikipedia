import domain.AnswerToParagraph;
import domain.Question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestionAnswerBuilder {
    public static List<QuestionAnswer> buildFromFilterAnswerParaMap(List<AnswerToParagraph> answerToParagraphs,
                                                                    List<Question> questions) {
        return questions.stream()
                .map(question -> {
                    Optional<AnswerToParagraph> answerToParagraph = filterAnswerToParaByQuestion(answerToParagraphs,
                            question);
                    return answerToParagraph.map(answer -> new QuestionAnswer(question.getSentence(),
                            answer.getAnswer())).orElse(new QuestionAnswer(question.getSentence(), ""));
                }).collect(Collectors.toList());
    }

    private static Optional<AnswerToParagraph> filterAnswerToParaByQuestion(List<AnswerToParagraph> answerToParagraphs, Question question) {
        return answerToParagraphs.stream()
                .filter(answerToParagraph -> isMatchingAnswer(question.getKeyWordsInAQuestion(),
                        answerToParagraph))
                .findFirst();
    }

    private static boolean isMatchingAnswer(List<String> questionKeywords, AnswerToParagraph answerToParagraph) {
        return questionKeywords
                .stream()
                .anyMatch(questionKeyWord -> answerToParagraph.getAnswer().contains(questionKeyWord) || answerToParagraph
                        .getSentences().stream().anyMatch(sentence -> sentence.contains(questionKeyWord)));

    }
}

