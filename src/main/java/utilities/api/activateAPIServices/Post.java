package utilities.api.activateAPIServices;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.reporting.ExtentReportPrint;
import utilities.api.restUtils.RequestSpecificationGenerator;

import static io.restassured.RestAssured.given;


public class Post {

    public static Response performPost(String url, Object requestBody) {
        RequestSpecification requestSpecification = RequestSpecificationGenerator.getRequestSpecification(requestBody);
        Response response =  requestSpecification.post(url);
        ExtentReportPrint.printRequestLogInReport(requestSpecification);
        ExtentReportPrint.printResponseLogInReport(response);
        return response;
    }
}
