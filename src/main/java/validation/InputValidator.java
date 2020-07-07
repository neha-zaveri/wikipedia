package validation;

import domain.Sentence;

import java.util.List;

public class InputValidator {
    public void validate(List<String> lines) throws Exception {
        if (lines == null) {
            throw new Exception("Empty input. Please enter input");
        }
        if (lines.size() != 7) {
            throw new Exception("Please provide input in valid format. Must contain minimum 7 lines");
        }
    }
}
