package utilities.textConvert;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayConvert {

    public static ArrayList<String> stringToArrayList(String text, String charForSplit){
        return new ArrayList<>(Arrays.asList(text.split(charForSplit)));
    }
}
