package com.wiki.domain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuestionTest {

    @Test
    public void shouldReturnQuestionWithoutStopWords() {
        String question = "What is the aim of the Quagga Project?";
        Question questionObj = new Question(question);
        List<String> questionWithOutPropositions = questionObj.getKeyWordsInAQuestion();
        assertEquals("aim", questionWithOutPropositions.get(0));
        assertEquals("Quagga", questionWithOutPropositions.get(1));
        assertEquals("Project", questionWithOutPropositions.get(2));
    }
}