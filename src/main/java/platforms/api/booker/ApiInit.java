package platforms.api.booker;

import base.booker.BaseBooker;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiInit extends BaseBooker {

    public static void api_init(){

        platformName = "api";
        System.out.println(platformName);
        /*apiJsonInit();*/
        initBookingApiVariables();
    }

    /*public static void apiJsonInit(){

        try {
            jsonString = new String(Files.readAllBytes(Paths.get("path")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static void initBookingApiVariables(){
        if (environment.equalsIgnoreCase("test")){
            environmentBaseUrl = "https://restful-booker.herokuapp.com/";
        } else if (environment.equalsIgnoreCase("preProd")){
            environmentBaseUrl = "https://restful-booker.herokuapp.com/";
        } else if (environment.equalsIgnoreCase("prod")){
            environmentBaseUrl = "https://restful-booker.herokuapp.com/";
        }

        ping = environmentBaseUrl + "ping";
        createToken = environmentBaseUrl + "auth";
        urlGetSpecific = environmentBaseUrl + "booking/{id}";
        urlGetAll = environmentBaseUrl + "booking";
        urlPost = environmentBaseUrl + "booking";
        urlPut = environmentBaseUrl + "booking/{id}";
        urlPatch = environmentBaseUrl + "booking/{id}";
        urlDelete = environmentBaseUrl + "booking/{id}";
    }
}
