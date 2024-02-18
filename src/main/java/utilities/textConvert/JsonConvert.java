package utilities.textConvert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert {

    public static String jsonStringToPrettyJson(String jsonString) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.readValue(jsonString,String.class);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }
}
