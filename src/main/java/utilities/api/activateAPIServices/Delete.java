package utilities.api.activateAPIServices;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.reporting.ExtentReportPrint;
import utilities.api.restUtils.RequestSpecificationGenerator;

public class Delete {

    public static Response delete(String pathParamName, String pathParamValue, String url){
        RequestSpecification requestSpecification = RequestSpecificationGenerator.getRequestSpecification(pathParamName,pathParamValue);
        Response response =  requestSpecification.delete(url);
        ExtentReportPrint.printRequestLogInReport(requestSpecification);
        ExtentReportPrint.printResponseLogInReport(response);
        return response;
    }
}
