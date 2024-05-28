package utilities.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import utilities.asserts.Verifications;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonStringsCompare {

    static boolean jsonsEqual = true;

    public static boolean assertJsonEquality(String expectedJson, String responseJson, List<String> ignoreFields, String testName){

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = null;
        try {
            node1 = mapper.readTree(expectedJson);
        }catch (IOException e){
            e.printStackTrace();
        }
        JsonNode node2 = null;
        try {
            node2 = mapper.readTree(responseJson);
        }catch (IOException e){
            e.printStackTrace();
        }

        return compareJsonNodes(node1,node2,"",ignoreFields,testName);
    }

    private static boolean compareJsonNodes(JsonNode expectedJsonNode, JsonNode responseJsonNode, String currentPath,
                                            List<String> ignoreFields, String testName){
        if (expectedJsonNode.equals(responseJsonNode)){
            return jsonsEqual;
        }
        if (expectedJsonNode.isObject() && responseJsonNode.isObject()){
            ObjectNode objectNode1 = (ObjectNode) expectedJsonNode;
            ObjectNode objectNode2 = (ObjectNode) responseJsonNode;

            Set<String> expectedFieldNames = new HashSet<>();
            objectNode1.fieldNames().forEachRemaining(expectedFieldNames::add);

            Set<String> responseFieldNames = new HashSet<>();
            objectNode2.fieldNames().forEachRemaining(responseFieldNames::add);

            Set<String> missingFieldsInResponse = new HashSet<>(expectedFieldNames);
            missingFieldsInResponse.removeAll(responseFieldNames);
            if (!missingFieldsInResponse.isEmpty()){
                Verifications.verifyFail("Fields present in expectedJson but not in responseJson at path " + currentPath + ": " +
                        missingFieldsInResponse);
                jsonsEqual = false;
            }

            Set<String> missingFieldsInExpected = new HashSet<>(responseFieldNames);
            missingFieldsInExpected.removeAll(expectedFieldNames);
            if (!missingFieldsInExpected.isEmpty()){
                Verifications.verifyFail("Fields present in responseJson but not in expectedJson at path " + currentPath + ": " +
                        missingFieldsInExpected);
                jsonsEqual = false;
            }

            expectedFieldNames.retainAll(responseFieldNames); //keep only the common field names

            expectedFieldNames.forEach(fieldName -> {
                if (currentPath.equals("")){
                    if (!ignoreFields.contains(fieldName)){
                        JsonNode fieldNode1 = objectNode1.get(fieldName);
                        JsonNode fieldNode2 = objectNode2.get(fieldName);
                        compareJsonNodes(fieldNode1,fieldNode2,fieldName,ignoreFields,testName);
                    }
                }else {
                    if (!ignoreFields.contains(currentPath + "." + fieldName)){
                        JsonNode fieldNode1 = objectNode1.get(fieldName);
                        JsonNode fieldNode2 = objectNode2.get(fieldName);
                        String fieldsPath = currentPath + "." + fieldName;
                        compareJsonNodes(fieldNode1,fieldNode2,fieldsPath,ignoreFields,testName);
                    }
                }
            });
        } else if (expectedJsonNode.isArray() && responseJsonNode.isArray()) {

            ArrayNode arrayNode1 = (ArrayNode) expectedJsonNode;
            ArrayNode arrayNode2 = (ArrayNode) responseJsonNode;

            if (arrayNode1.size() != arrayNode2.size()){
                Verifications.verifyFail("Difference: Array size mismatch at path " + currentPath);
                jsonsEqual = false;
            }

            for (int i = 0; i<arrayNode1.size(); i++){
                compareJsonNodes(arrayNode1.get(i),arrayNode2.get(i),currentPath + "[" + i +"]", ignoreFields,testName);
            }

        } else {
            Verifications.verifyFail("on " + testName + " - " + "difference at path " + currentPath + ": expected " +
                    expectedJsonNode + " but get " + responseJsonNode);
            jsonsEqual = false;
        }
        return jsonsEqual;

    }
}
