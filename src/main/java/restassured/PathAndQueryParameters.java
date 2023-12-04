package restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class PathAndQueryParameters {

    // https://reqres.in/api/users?page=2&id=5

    @Test
    public void testQueryAndPath(){
                     //path parameter
        given().
                queryParam("page",2).
                queryParam("id",5).when().
                get("https://reqres.in/api/users").then().statusCode(200).log().all();


    }
}
