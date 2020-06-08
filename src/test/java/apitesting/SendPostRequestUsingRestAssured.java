package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class SendPostRequestUsingRestAssured {

    //sending Post request through Form Parameters

//    public static void main(String[] args) {
//
//        Response response = given().auth().basic("sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf", "")
//                                .formParam("name", "David M. Fischer")
//                                .formParam("email", "DavidMFischer@armyspy.com")
//                                .formParam("phone", "510-455-8167")
//                                .post("https://api.stripe.com/v1/customers");
//
//        response.prettyPrint();
//    }

    //sending POST request through JSON String Data

/*    public static void main(String[] args) {

        String bodyString = "{\"email\":\"eve.holt@reqres.in\", \"password\": \"pistol\"}";
        //String bodyString = "{\"name\":\"Priscilla J. Resto\", \"email\":\"PriscillaJResto@rhyta.com\"}";

        Response response = given().contentType(ContentType.JSON).body(bodyString).post("https://reqres.in/api/register");
*//*
        Response response = given().auth().basic("sk_test_eV9OUy5mi6yPCbx2LUxmip2300p6l0XdXf", "")
                .contentType("application/x-www-form-urlencoded").body(bodyString)
                .post("https://api.stripe.com/v1/customers"); //Received "unknown parameter:" error for Stripe
*//*
        response.prettyPrint();

    }*/

    //sending POST request by passing JSON body in a form of a map
    //jackson databind dependency was added
   /* public static void main(String[] args) {

        String bodyString = "{\"email\":\"eve.holt@reqres.in\", \"password\": \"pistol\"}";

        HashMap<String,String> map = new HashMap<String, String>();
        map.put("email", "eve.holt@reqres.in");
        map.put("password", "pistol");

        Response response = given().contentType(ContentType.JSON).body(map).post("https://reqres.in/api/register");
        response.prettyPrint();

    }*/

   //sending POST request by passing JSON file
   public static void main(String[] args) {


//       Response response = given().contentType(ContentType.JSON).body(new File("./users.json")).post("http://localhost:8080/api/users");

       //to see all the information sent in the request add log().all()
       Response response = given().contentType(ContentType.JSON)
               .body(new File("./users.json"))
               .log().all()
               .post("http://localhost:8080/api/users");


       response.prettyPrint();
       System.out.println(response.getStatusCode());

       Response response1 = given().contentType(ContentType.JSON).get("http://localhost:8080/api/users");
       response1.prettyPrint();
       System.out.println(response1.getStatusCode());


   }
}
