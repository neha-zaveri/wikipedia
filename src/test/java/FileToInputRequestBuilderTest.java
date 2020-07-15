import com.wiki.domain.InputRequest;
import com.wiki.utilities.FileToInputRequestBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileToInputRequestBuilderTest {
    @Test
    public void shouldBuildInputRequestFromFile() throws Exception {
        InputRequest inputRequest = FileToInputRequestBuilder
                .build("src/main/resources/input.txt");

        assertNotNull(inputRequest);
        assertNotNull(inputRequest.getParagraph());
        assertEquals(5, inputRequest.getQuestions().size());
        assertNotNull(inputRequest.getAnswers());
    }
}