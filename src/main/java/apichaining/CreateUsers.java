package apichaining;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateUsers {

    String token = "e478b360415be8bca2a17f2a458e166c32a78dba8e9fdc97abbb21f6a83ee68c";


    /*
    "id": 5809204,
    "name": "Luciana Beer",
    "email": "juan.ziemann@gmail.com",
    "gender": "male",
    "status": "inactive"
     */

    @Test
    public void createUsers(ITestContext iTestContext){
        Faker faker = new Faker();
        JSONObject jo = new JSONObject();
        jo.put("name",faker.name().fullName());
        jo.put("gender","male");
        jo.put("email",faker.internet().emailAddress());
        jo.put("status","inactive");

//    int id =   given().headers("Authorization","Bearer "+token).
//                contentType("application/json").
//                body(jo.toString()).
//                when().post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");

    //iTestContext.getSuite().setAttribute("userid",id);

    }
}
