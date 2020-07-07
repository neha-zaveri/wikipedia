import domain.Answer;
import domain.AnswerToParagraph;
import domain.Paragraph;
import domain.Sentence;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParagraphFilterTest {

    public static final Paragraph PARAGRAPH = new Paragraph(new Sentence("Zebras are several species of African " +
            "equids (horse family)" +
            " " +
            "united by their distinctive black and white stripes. " +
            "Their stripes come in different patterns, unique to each individual. " +
            "They are generally social animals that live in small harems to large herds. " +
            "Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated. " +
            "There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. " +
            "The plains zebra and the mountain zebra belong to the subgenus Hippotigris, " +
            "but Grévy's zebra is the sole species of subgenus Dolichohippus. " +
            "The latter resembles an ass, to which it is closely related, while the former two are more " +
            "horse-like. " +
            "All three belong to the genus Equus, along with other living equids. The unique stripes of zebras " +
            "make " +
            "them one of the animals most familiar to people. " +
            "They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, " +
            "mountains, and coastal hills. " +
            "However, various anthropogenic factors have had a severe impact on zebra populations, in particular " +
            "hunting for skins and habitat destruction. " +
            "Grévy's zebra and the mountain zebra are endangered. While plains zebras are much more plentiful, " +
            "one subspecies - the Quagga - became extinct in the late 19th century. " +
            "Though there is currently a plan, called the Quagga Project, that aims to breed zebras that are " +
            "phenotypically similar to the Quagga, " +
            "in a process called breeding back.", "\\."));
    public static final Answer ANSWER = new Answer(new Sentence("subgenus Hippotigris; " +
            "the plains zebra, the Grévy's zebra and the mountain zebra;" +
            "horses and donkeys;" +
            "aims to breed zebras that are phenotypically similar to the quagga;" +
            " Grévy's zebra and the mountain zebra", ";"));

    @Test
    public void shouldFilterParaByAnswers() {
        List<AnswerToParagraph> linesRelevantByAnswers = ParagraphFilter.getLinesRelevantByAnswers(PARAGRAPH, ANSWER);

        assertEquals(5, linesRelevantByAnswers.size());
        assertEquals(1, getLinesByAnswer(linesRelevantByAnswers, "subgenus Hippotigris").getSentences().size());
        assertEquals(1, getLinesByAnswer(linesRelevantByAnswers, "horses and donkeys").getSentences().size());
        assertEquals(1, getLinesByAnswer(linesRelevantByAnswers, "aims to breed zebras that are phenotypically " +
                "similar to the quagga").getSentences().size());
        assertEquals(1, getLinesByAnswer(linesRelevantByAnswers, "the plains zebra, the Grévy's zebra and the " +
                "mountain zebra")
                .getSentences().size());
        assertEquals(2,
                getLinesByAnswer(linesRelevantByAnswers, "Grévy's zebra and the mountain zebra").getSentences().size());

    }

    private AnswerToParagraph getLinesByAnswer(List<AnswerToParagraph> linesRelevantByAnswers, String key) {
        return linesRelevantByAnswers.stream().filter(answerToParagraph -> answerToParagraph.getAnswer()
                .equalsIgnoreCase(key)).findFirst().get();
    }
}