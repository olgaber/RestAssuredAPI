package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class SendGetRequestUsingRestAssured {

    //Get All Users

    public static void main(String[] args) {

//        Response response = given().param("limit", 3).auth().basic("sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf", "")
//                            .get("https://api.stripe.com/v1/customers");

        Response response = given().formParam("limit", 3)
                .formParam("email", "JudithRForbush@jourrapide.com")
                .auth().basic("sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf", "")
                .get("https://api.stripe.com/v1/customers");
        //response.prettyPrint();
        String jsonResponse = response.asString();
        System.out.println(jsonResponse);

        System.out.println("Response code: " + response.statusCode());

        //set content type (1)
        //given().contentType(ContentType.JSON);
        //set content type (2)
        //given().contentType("application/JSON");
        //set content type (3)
        //given().header("content-type", "application/JSON").auth().basic("sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf", "");

    }
/*
    //Get a specific user

    public static void main(String[] args) {
        Response response = given().header("Authorization", "Bearer sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf")
            .get("https://api.stripe.com/v1/customers/cus_HEDiqBKlaDiSRc");
        response.prettyPrint();
    }
*/
}
