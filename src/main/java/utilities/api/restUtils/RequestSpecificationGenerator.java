package utilities.api.restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestSpecificationGenerator {

    public static RequestSpecification getRequestSpecification(Object requestBody){

        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all();
    }

    public static RequestSpecification getRequestSpecification(String pathParamName, String pathParamValue, Object requestBody){

        return given()
                .contentType(ContentType.JSON)
                .pathParam(pathParamName,pathParamValue)
                .body(requestBody)
                .log().all();
    }

    public static RequestSpecification getRequestSpecification(String pathParamName, String pathParamValue){

        return given()
                .contentType(ContentType.JSON)
                .pathParam(pathParamName,pathParamValue)
                .log().all();
    }

    public static RequestSpecification getRequestSpecification(String queryParamName, Object queryParamValue){

        return given()
                .contentType(ContentType.JSON)
                .queryParam(queryParamName,queryParamValue)
                .log().all();
    }

    public static RequestSpecification getRequestSpecification(){

        return given()
                .contentType(ContentType.JSON)
                .log().all();
    }
    

}
