package com.wiki;

import com.wiki.domain.AnswerToParagraph;
import com.wiki.domain.InputRequest;
import com.wiki.domain.QuestionAnswer;
import com.wiki.utilities.FileToInputRequestBuilder;
import com.wiki.utilities.ParagraphFilter;
import com.wiki.utilities.QuestionAnswerBuilder;

import java.util.List;

public class Main {

    public static void main(String args[]) throws Exception {
        String fileName = "src/main/resources/input.txt";
        InputRequest inputRequest = FileToInputRequestBuilder.build(fileName);
        List<AnswerToParagraph> linesRelevantByAnswers =
                ParagraphFilter.getLinesRelevantByAnswers(inputRequest.getParagraph(), inputRequest.getAnswers());

        List<QuestionAnswer> questionAnswers =
                QuestionAnswerBuilder.buildFromFilterAnswerParaMap(linesRelevantByAnswers, inputRequest.getQuestions());

        questionAnswers.forEach(questionAnswer -> System.out.println(questionAnswer.getAnswer()));

    }
}
