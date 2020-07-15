package com.wiki.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {
    private List<String> individualLines;

    public Sentence(String line, String separator) {
        this.individualLines = Arrays.asList(line.split(separator));
    }

    public List<String> getIndividualLines() {
        return new ArrayList<>(individualLines);
    }
}
