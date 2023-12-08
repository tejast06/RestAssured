package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {

    static ResourceBundle getUrl(){
        ResourceBundle routes = ResourceBundle.getBundle("config"); {
            return routes;
        }

    }

    public static Response createUser(User payload) {
       String post_url =  getUrl().getString("postUrl");
        Response response = given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().post(post_url);
        return response;
    }

    public static Response getUser(String userName) {
        String get_url =  getUrl().getString("getUrl");

        Response response = given().param("username", userName).
                when().get(get_url);
        return response;
    }

    public static Response updateUser(String username, User payload) {
        String update_url =  getUrl().getString("updateUrl");

        Response response = given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                pathParam("username", username).
                body(payload).
                when().put(update_url);
        return response;
    }

    public static Response deleteUser(String userName) {
        String delete_url =  getUrl().getString("deleteUrl");
        Response response = given().param("username", userName).
                when().get(delete_url);
        return response;
    }
}
