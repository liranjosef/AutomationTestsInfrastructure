package utilities.api.activateAPIServices;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.reporting.ExtentReportPrint;
import utilities.api.restUtils.RequestSpecificationGenerator;

public class Patch {

    public static Response performPatch(String pathParamName, String pathParamValue, String url, Object requestBody) {
        RequestSpecification requestSpecification = RequestSpecificationGenerator.getRequestSpecification(
                pathParamName,pathParamValue,requestBody);
        Response response =  requestSpecification.patch(url);
        ExtentReportPrint.printRequestLogInReport(requestSpecification);
        ExtentReportPrint.printResponseLogInReport(response);
        return response;
    }
}
