package test.bsuir.bonus.reader;

import by.bsuir.bonus.exception.BonusException;
import by.bsuir.bonus.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileReaderTest {
    private FileReader reader = new FileReader();

    @Test(description = "read all lines in correct file",
            dataProvider = "dataForCorrectTextReader")
    public void testReadText(String filepath, List<String> expected)throws BonusException {
        List<String> actual = reader.readAllLines(filepath);
        assertThat(actual).containsExactlyElementsOf(expected);

    }

    @DataProvider(name = "dataForCorrectTextReader")
    public Object[][] dataForCorrectTextReader(){
        return new Object[][]{
                {"input/short.txt", List.of("PSP",
                        "Morning",
                        "Ham",
                        "Beer",
                        "Ham",
                        "PSP",
                        "fortune",
                        "why",
                        "Ham")},
                {"input/empty.txt", List.of()}

        };
    }

    @Test(description = "test reader throws InfoHandlingException",
            dataProvider = "dataForIncorrectReader",
            expectedExceptions = BonusException.class)
    public void testReadAllException(String filepath)throws BonusException {
        reader.readAllLines(filepath);
    }

    @DataProvider(name = "dataForIncorrectReader")
    public Object[][] dataForIncorrectReader(){
        return new Object[][]{
                {"input/notExist.txt"},
                {"input/\\escapeChar.txt"},
        };
    }
}
