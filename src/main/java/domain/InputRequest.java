package domain;

import java.util.List;

public class InputRequest {
    private Paragraph paragraph;
    private List<Question> questions;
    private Answer answer;

    public InputRequest(Paragraph paragraph, List<Question> questions, Answer answer) {
        this.paragraph = paragraph;
        this.questions = questions;
        this.answer = answer;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Answer getAnswer() {
        return answer;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Paragraph paragraph;
        private List<Question> questions;
        private Answer answer;

        private Builder() {
        }


        public Builder withParagraph(Sentence paragraph) {
            this.paragraph = new Paragraph(paragraph);
            return this;
        }

        public Builder withQuestions(List<Question> questions) {
            this.questions = questions;
            return this;
        }

        public Builder withAnswers(Sentence answer) {
            this.answer = new Answer(answer);
            return this;
        }

        public InputRequest build() {
            return new InputRequest(paragraph, questions, answer);
        }
    }
}
