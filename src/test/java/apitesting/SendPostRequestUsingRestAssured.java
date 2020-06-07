package apitesting;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SendPostRequestUsingRestAssured {

    public static void main(String[] args) {

        Response response = given().auth().basic("sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf", "")
                                .formParam("name", "David M. Fischer")
                                .formParam("email", "DavidMFischer@armyspy.com")
                                .formParam("phone", "510-455-8167")
                                .post("https://api.stripe.com/v1/customers");

        response.prettyPrint();
    }
}
