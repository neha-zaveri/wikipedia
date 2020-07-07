package domain;

import java.util.List;

public class Answer {
    private List<String> individualAnswer;

    public Answer(Sentence sentence) {
        this.individualAnswer = sentence.getIndividualLines();
    }

    public List<String> getIndividualAnswer() {
        return individualAnswer;
    }
}
