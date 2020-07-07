import domain.AnswerToParagraph;
import domain.InputRequest;

import java.util.List;

public class Main {

    public static void main(String args[]) throws Exception {
        String fileName = "/Users/neha/repos/personal_repos/wikipedia/src/main/resources/input.txt";
        InputRequest inputRequest = FileToInputRequestBuilder.build(fileName);
        List<AnswerToParagraph> linesRelevantByAnswers =
                ParagraphFilter.getLinesRelevantByAnswers(inputRequest.getParagraph(), inputRequest.getAnswer());

        List<QuestionAnswer> questionAnswers =
                QuestionAnswerBuilder.buildFromFilterAnswerParaMap(linesRelevantByAnswers, inputRequest.getQuestions());

        questionAnswers.forEach(questionAnswer -> System.out.println(questionAnswer.getAnswer()));

    }
}
