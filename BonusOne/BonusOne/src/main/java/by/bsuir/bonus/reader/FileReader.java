package by.bsuir.bonus.reader;

import by.bsuir.bonus.exception.BonusException;
import by.bsuir.bonus.validator.BonusValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public List<String> readAllLines(String filename) throws BonusException {
        BonusValidator validator = BonusValidator.getInstance();
        if (!validator.isValidFilepath(filename)){
            throw new BonusException("File path is invalid: " + filename);
        }
        List<String> text;
        Path path = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(path)){
            text = br.lines().toList();
        } catch (IOException e) {
            throw new BonusException("Input error while reading file", e);
        }
        return text;
    }
}
