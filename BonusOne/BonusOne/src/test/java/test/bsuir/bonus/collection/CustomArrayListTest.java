package test.bsuir.bonus.collection;

import by.bsuir.bonus.collection.CustomArrayList;
import by.bsuir.bonus.exception.BonusException;
import by.bsuir.bonus.reader.FileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static java.util.Map.entry;

public class CustomArrayListTest {
    private CustomArrayList arrayList;
    private static final String FILE_PATH = "input/short.txt";


    @BeforeClass
    public void init() throws BonusException {
        FileReader reader = new FileReader();
        List<String> lines = reader.readAllLines(FILE_PATH);
        arrayList = new CustomArrayList();
        lines.forEach(line -> arrayList.add(line));
    }



    @Test
    public void testCountSameStrings() {
        Map<String, Long> actual = arrayList.countSameStrings();
        Map<String, Long> expected = Map.of("Ham", 3L, "PSP", 2L);
        assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    public void testReverseAll() {
        List<String> actual = arrayList.reverseAll();
        List<String> expected = List.of("PSP", "gninroM", "maH", "reeB", "maH", "PSP", "enutrof", "yhw", "maH");
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void testCountCharacters() {
        Map<String, Long> actual = arrayList.countCharacters();
        Map<String, Long> expected = Map.ofEntries(entry("B", 1L),
                entry("H", 3L), entry("M", 1L), entry("P", 4L), entry("S", 2L),
                entry("a", 3L), entry("e", 3L), entry("f", 1L), entry("g", 1L),
                entry("h", 1L), entry("i", 1L), entry("m", 3L), entry("n", 3L),
                entry("o", 2L), entry("r", 3L), entry("t", 1L), entry("u", 1L),
                entry("w", 1L), entry("y", 1L));

        assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    public void testContainsAll() {
        List<String> actual = arrayList.containsAll("r");
        List<String> expected = List.of("Morning", "Beer", "fortune");
        assertThat(actual).containsExactlyElementsOf(expected);

    }

    @Test
    public void testCompareInnerObjects() {
        int actual = arrayList.compareInnerObjects(0, 4);
        int expected = 8;
        assertEquals(actual, expected);
    }

    @Test
    public void testCountInnerSize() {
        List<Integer> actual = arrayList.countInnerSize();
        List<Integer> expected = List.of(3, 3, 3, 3, 3, 3, 4, 7, 7);
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void testStaticAdd() {
        for (int i = 0; i < 5; i++) {
            arrayList.staticAdd(Integer.toString(i));
        }
        String actualFirst = arrayList.get(0);
        String actualLast = arrayList.get(arrayList.size() - 1);
        int actualSize = arrayList.size();

        int expectedSize = 10;
        String expectedFirst = "Ham";
        String expectedLast = "4";

        assertEquals(actualSize, expectedSize);
        assertEquals(actualFirst, expectedFirst);
        assertEquals(actualLast, expectedLast);

    }
}