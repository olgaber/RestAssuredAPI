package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class PassCompexJasonInBody{

    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name", "Natasha E. Minor");
        map.put("email", "NatashaEMinor@jourrapide.com");

        ArrayList<Integer> phonesList = new ArrayList<Integer>();
        phonesList.add(369287072);
        phonesList.add(369287073);
        map.put("phone", phonesList);

        HashMap<String,String> address = new HashMap<String, String>();
        address.put("line1", "2094 Farm Meadow Drive");
        address.put("city", "Scottsdale");
        address.put("state", "AZ");
        address.put("zip", "85256");
        map.put("address", address);

        HashMap<String,Object> edObject1 = new HashMap<String, Object>();
        edObject1.put("course", "B.Tech");
        edObject1.put("marks", 75);

        HashMap<String,Object> edObject2 = new HashMap<String, Object>();
        edObject2.put("course", "M.Tech");
        edObject2.put("marks", 85);

        ArrayList<Object> edObjects = new ArrayList<Object>();
        edObjects.add(edObject1);
        edObjects.add(edObject2);

        map.put("education", edObjects);

        Response response = given().contentType(ContentType.JSON)
                .body(map)
                .log().all()
                .post("http://localhost:8080/api/users");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }


}
