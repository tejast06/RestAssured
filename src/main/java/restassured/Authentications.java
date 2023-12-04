package restassured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentications {

    //@Test
    public void testAuthBasic(){
        given().auth().basic("postman","password").
                when().get("https://postman-echo.com/basic-auth").
                then().statusCode(200).body("authenticated",equalTo("true"));
    }

    //@Test
    public void testAuthDigest(){
        given().auth().digest("postman","password").
                when().get("https://postman-echo.com/basic-auth").
                then().statusCode(200).body("authenticated",equalTo("true"));
    }

    //@Test
    public void testAuthPreemptive(){
        given().auth().preemptive().basic("postman","password");
                when().get("https://postman-echo.com/basic-auth").
                then().statusCode(200).body("authenticated",equalTo("true"));
    }

    //@Test
    public void testAuthBearerToken(){
        String token = "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";
        given().headers("Authorization","Bearer "+token).
                when().get("https://api.github.com/users/repos").
                then().statusCode(200).log().all();
    }

    //@Test
    public void testOAuth1Authentication(){
        given().auth().oauth("consumerKey","consumerSecret","accessToken",
                "secretToken").
                when().get("url").then().statusCode(200).log().all();
    }

    //@Test
    public void testOAuth2Authentication(){
        given().auth().oauth2("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").
                when().get("url").then().statusCode(200).log().all();
    }

    @Test
    public void testAPIKey(){
        given().queryParam("appid","9ed720cd3927d91d0528c47e5a0eb42c").
                when().get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7").
                then().statusCode(200).log().all();

        given().queryParam("appid","9ed720cd3927d91d0528c47e5a0eb42c").
                pathParam("path","data/2.5/forecast/daily").
                queryParam("q","Delhi").
                queryParam("units","metric").
                queryParam("cnt","7").
                when().get("https://api.openweathermap.org/{path}").then().statusCode(200);
    }
}
