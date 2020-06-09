package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreatingJSONRuntime {
    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Robert S. Forehand");
        jsonObject.put("email", "RobertSForehand@armyspy.com");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(12345);
        jsonArray.put(123334);

        jsonObject.put("phone", jsonArray);

        JSONObject address = new JSONObject();
        address.put("line1", "4755 Marietta Street");
        address.put("city", "Oakland");
        address.put("state", "CA");
        address.put("zip", "94612");
        jsonObject.put("address", address);

        JSONArray edObjects = new JSONArray();

        JSONObject edObj1 = new JSONObject();
        edObj1.put("course", "BTech");
        edObj1.put("grade", 75);

        JSONObject edObj2 = new JSONObject();
        edObj2.put("course", "MTech");
        edObj2.put("grade", 85);

        edObjects.put(edObj1);
        edObjects.put(edObj2);

        jsonObject.put("education", edObjects);

        Response response = given().contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .log().all()
                .post("http://localhost:8080/api/users");
        response.prettyPrint();
        System.out.println(response.getStatusCode());


    }
}
