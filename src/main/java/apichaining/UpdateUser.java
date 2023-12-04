package apichaining;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class UpdateUser {
    String token = "e478b360415be8bca2a17f2a458e166c32a78dba8e9fdc97abbb21f6a83ee68c";


    @Test
    public void updateUser(ITestContext iTestContext){
        int id=(Integer)iTestContext.getSuite().getAttribute("userid");
        Faker faker = new Faker();
        JSONObject jo = new JSONObject();
        jo.put("name",faker.name().fullName());
        jo.put("gender","male");
        jo.put("email",faker.internet().emailAddress());
        jo.put("status","active");



     given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                body(jo.toString()).
                pathParam("idName",id).
                body(jo.toString()).
                when().put("https://gorest.co.in/public/v2/users/{idName}").then().statusCode(200).log().all();


    }
}
