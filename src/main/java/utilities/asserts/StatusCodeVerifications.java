package utilities.asserts;

import io.restassured.response.Response;

public class StatusCodeVerifications {

    public static void verifyStatusCode200(Response response){
        Verifications.verifyInts(response.statusCode(),200, "status code 200 test");
    }
    public static void verifyStatusCode201(Response response){
        Verifications.verifyInts(response.statusCode(),201, "status code 201 test");
    }
    public static void verifyStatusCode404(Response response){
        Verifications.verifyInts(response.statusCode(),404, "status code 404 test");
    }
    public static void verifyStatusCode406(Response response){
        Verifications.verifyInts(response.statusCode(),406, "status code 406 test");
    }
}
