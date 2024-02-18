package utilities.textConvert;

import org.apache.commons.lang.StringUtils;

public class TextSubstring {

    public static String cutStringBetweenTwoChars(String text, String fromChar, String toChar){
        return StringUtils.substringBetween(text, fromChar, toChar);
    }


}
