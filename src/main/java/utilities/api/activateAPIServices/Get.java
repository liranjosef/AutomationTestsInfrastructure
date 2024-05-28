package utilities.api.activateAPIServices;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.reporting.ExtentReportPrint;
import utilities.api.restUtils.RequestSpecificationGenerator;

import static io.restassured.RestAssured.given;

public class Get {

    public static Response getSpecific(String pathParamName, String pathParamValue, String url){
        RequestSpecification requestSpecification = RequestSpecificationGenerator.getRequestSpecification(pathParamName,pathParamValue);
        Response response =  requestSpecification.get(url);
        ExtentReportPrint.printRequestLogInReport(requestSpecification);
        ExtentReportPrint.printResponseLogInReport(response);
        return response;
    }

    public static Response getSpecificWithQueryParam(String queryParamName, Object queryParamValue, String url){
        RequestSpecification requestSpecification = RequestSpecificationGenerator.getRequestSpecification(queryParamName,queryParamValue);
        Response response =  requestSpecification.get(url);
        ExtentReportPrint.printRequestLogInReport(requestSpecification);
        ExtentReportPrint.printResponseLogInReport(response);
        return response;
    }

    public static Response get(String url){
        RequestSpecification requestSpecification = RequestSpecificationGenerator.getRequestSpecification();
        Response response =  requestSpecification.get(url);
        ExtentReportPrint.printRequestLogInReport(requestSpecification);
        ExtentReportPrint.printResponseLogInReport(response);
        return response;
    }

    /*public static Response getWithoutSSLCertificate(String url){
        return given()
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .get(url);
    }*/
}
