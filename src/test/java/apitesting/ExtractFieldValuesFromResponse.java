package apitesting;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ExtractFieldValuesFromResponse {

    public static void main(String[] args) {

        Response response = given().auth().basic("sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf", "")
                .formParam("name", "Roberto M. Corcoran")
                .formParam("email", "RobertoMCorcoran@teleworm.us")
                .formParam("address[line1]", "4417 Shinn Avenue")
                .formParam("address[city]", "Crafton")
                .formParam("address[state]", "PA")
                .formParam("address[postal_code]", "15205")
                .formParam("preferred_locales[0]", "yes")
                .post("https://api.stripe.com/v1/customers");

        response.prettyPrint();

        JsonPath json = response.jsonPath();
        System.out.println(json.get("id"));
        System.out.println(response.jsonPath().get("name"));
        System.out.println(response.jsonPath().get("address.line1"));
        System.out.println(json.get("preferred_locales[0]"));

        //get size
        System.out.println(json.getMap("$").size());

        //get size of address (json object)
        System.out.println(json.getMap("address").size());

        //get size of preferred locales (array)
        System.out.println(json.getList("preferred_locales").size());

    }
}
