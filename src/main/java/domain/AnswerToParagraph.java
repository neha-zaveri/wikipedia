package domain;

import java.util.List;

public class AnswerToParagraph {
    private String answer;
    private List<String> sentences;

    public AnswerToParagraph(String answer, List<String> sentences) {
        this.answer = answer;
        this.sentences = sentences;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getSentences() {
        return sentences;
    }
}
