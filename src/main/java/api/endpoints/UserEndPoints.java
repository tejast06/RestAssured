package api.endpoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


//create for create, read,update, delete operations
public class UserEndPoints {

    public static Response createUser(User payload) {
        Response response = given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().post(Routes.postUrl);
        return response;
    }

    public static Response getUser(String userName) {
        Response response = given().param("username", userName).
                when().get(Routes.getUrl);
        return response;
    }

    public static Response updateUser(String username, User payload) {
        Response response = given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                pathParam("username", username).
                body(payload).
                when().put(Routes.putUrl);
        return response;
    }

    public static Response deleteUser(String userName) {
        Response response = given().param("username", userName).
                when().get(Routes.deleteUrl);
        return response;


    }
}
