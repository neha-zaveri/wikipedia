package com.wiki.domain;

import java.util.List;

public class InputRequest {
    private Paragraph paragraph;
    private List<Question> questions;
    private List<String> answers;

    public InputRequest(Paragraph paragraph, List<Question> questions, List<String> answers) {
        this.paragraph = paragraph;
        this.questions = questions;
        this.answers = answers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public static final class Builder {
        private Paragraph paragraph;
        private List<Question> questions;
        private List<String> answers;

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

        public Builder withAnswers(List<String> answers) {
            this.answers = answers;
            return this;
        }

        public InputRequest build() {
            return new InputRequest(paragraph, questions, answers);
        }
    }
}
