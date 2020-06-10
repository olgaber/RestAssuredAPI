package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PassJSONUsingPOJO {

    public static void main(String[] args) {

        User user = new User("JamesDFowler@jourrapide.com", "James", "Fowler", "2908 Reynolds Alley", "Los Angeles", "CA", "90017");

        user.setMobileNumbers(1234, 2345, 45687);

        //for every json object separate POJO class is created

        Response response = given().contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .post("http://localhost:8080/api/users");

        response.prettyPrint();

        System.out.println(response.getStatusCode());
    }
}
