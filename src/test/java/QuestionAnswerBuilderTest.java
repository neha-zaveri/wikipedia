import domain.AnswerToParagraph;
import domain.Question;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuestionAnswerBuilderTest {
    @Test
    public void shouldBuildQuestionAnswer() {
        AnswerToParagraph answerToParagraph = new AnswerToParagraph("neha",
                Arrays.asList("My name is Neha", "Hi this is Neha!!"));

        Question question = new Question("What is my name");

        List<QuestionAnswer> result = QuestionAnswerBuilder
                .buildFromFilterAnswerParaMap(Collections.singletonList(answerToParagraph),
                        Collections.singletonList(question));

        assertNotNull(result);
        assertEquals("What is my name", result.get(0).getQuestion());
        assertEquals("neha", result.get(0).getAnswer());
    }

    @Test
    public void shouldGiveBlankAnswerIfNoMatch() {
        AnswerToParagraph answerToParagraph = new AnswerToParagraph("neha",
                Arrays.asList("My name is Neha", "Hi this is Neha!!"));

        Question question = new Question("What is happening?");

        List<QuestionAnswer> result = QuestionAnswerBuilder
                .buildFromFilterAnswerParaMap(Collections.singletonList(answerToParagraph),
                        Collections.singletonList(question));

        assertNotNull(result);
        assertEquals("What is happening?", result.get(0).getQuestion());
        assertEquals("", result.get(0).getAnswer());
    }
}