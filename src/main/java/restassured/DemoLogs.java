package restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DemoLogs {

    @Test
    public void fetchLogs(){
        given().when().get("https://reqres.in/api/users?page=2").
                then().log().body();
    }
}
