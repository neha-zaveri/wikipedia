import domain.InputRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileToInputRequestBuilderTest {
    @Test
    public void shouldBuildInputRequestFromFile() throws Exception {
        InputRequest inputRequest = FileToInputRequestBuilder.build("/Users/neha/repos/personal_repos/wikipedia/src" +
                "/main" +
                "/resources/input.txt");

        assertNotNull(inputRequest);
        assertNotNull(inputRequest.getParagraph());
        assertEquals(5, inputRequest.getQuestions().size());
        assertNotNull(inputRequest.getAnswer());
    }
}