package utilities.api.activateAPIServices;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.reporting.ExtentReportPrint;
import utilities.api.restUtils.RequestSpecificationGenerator;

public class Put {

    public static Response performPut(String pathParamName, String pathParamValue, String url, Object requestBody) {
        RequestSpecification requestSpecification = RequestSpecificationGenerator.getRequestSpecification(
                pathParamName,pathParamValue,requestBody);
        Response response =  requestSpecification.put(url);
        ExtentReportPrint.printRequestLogInReport(requestSpecification);
        ExtentReportPrint.printResponseLogInReport(response);
        return response;
    }
}
