package domain;

public class Paragraph {
    private Sentence sentence;

    public Paragraph(Sentence sentence) {
        this.sentence = sentence;
    }

    public Sentence getSentence() {
        return sentence;
    }
}
