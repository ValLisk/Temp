package by.bsuir.bonus.validator;

import java.io.File;

public class BonusValidator {
    private static BonusValidator instance;

    private BonusValidator(){}

    public static BonusValidator getInstance(){
        if (instance == null){
            instance = new BonusValidator();
        }
        return instance;
    }


    public boolean isValidFilepath(String filepath) {
        boolean isValid = false;
        if (filepath != null && !filepath.isBlank()){
            File file = new File(filepath);
            isValid = file.exists();
        }
        return isValid;
    }
}
