package utilities.textConvert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;

public class StringConvert {

    public static ArrayList<String> stringToArrayList(String text, String charForSplit){
        return new ArrayList<>(Arrays.asList(text.split(charForSplit)));
    }
    public static ArrayList<String> stringToArrayListWithoutSpaces(String text, String charForSplit){
        return new ArrayList<>(Arrays.asList(text.replaceAll("\\s","").split(charForSplit)));
    }
    public static String jsonStringToPrettyJson(String jsonString) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.readValue(jsonString,String.class);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }
}
