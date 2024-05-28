package utilities.readFileData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonFileConvert {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String,Object> jsonFileToMap(String jsonFileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        return objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>(){});
    }

}

