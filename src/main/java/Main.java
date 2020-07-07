import domain.InputRequest;

public class Main {

    public static void main(String args[]) throws Exception {
        String fileName = "/Users/neha/repos/personal_repos/wikipedia/src/main/resources/input.txt";
        InputRequest inputRequest = FileToInputRequestBuilder.build(fileName);
        ParagraphFilter.getLinesRelevantByAnswers(inputRequest.getParagraph(), inputRequest.getAnswer());
    }


}
