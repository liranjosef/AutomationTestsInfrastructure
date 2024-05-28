package booker.apiTests;

import booker.BaseBookerTest;
import platforms.api.booker.BodyGenerator;
import platforms.api.booker.pojo.Booking;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.api.activateAPIServices.*;

import static platforms.api.booker.ApiInit.api_init;

public class BookerTests extends BaseBookerTest {


    @Test
    public void getBooking(){
        api_init();
        Response response = Get.getSpecific("id","1211", urlGetSpecific);
        response.then().log().all();
        System.out.println(response.statusCode());
    }

    @Test
    public void getAllBookings(){
        api_init();
        Response response = Get.get(urlGetAll);
        response.then().log().all();
        System.out.println(response.statusCode());
    }

    @Test
    public void postBooking() {
        api_init();
        Booking requestBody = BodyGenerator.getCreateBookingBodyFromPojo();
        Response response = Post.performPost(urlPost,requestBody);
        response.then().log().all();
        System.out.println(response.statusCode());
    }

    @Test
    public void updateBooking() {
        api_init();
        Booking requestBodyAfterUpdate = BodyGenerator.getCreateBookingBodyFromPojo();
        Response response = Put.performPut("pathParamName", "pathParamValue",urlPut,requestBodyAfterUpdate);
        response.then().log().all();
        System.out.println(response.statusCode());
    }

    @Test
    public void patchBooking() {
        api_init();
        Booking requestBodyAfterUpdate = BodyGenerator.getCreateBookingBodyFromPojo();
        Response response = Patch.performPatch("pathParamName", "pathParamValue",urlPatch,requestBodyAfterUpdate);
        response.then().log().all();
        System.out.println(response.statusCode());
    }

    @Test
    public void deleteBooking(){
        api_init();
        Response response = Delete.delete("id","1211", urlDelete);
        response.then().log().all();
        System.out.println(response.statusCode());
    }

}
