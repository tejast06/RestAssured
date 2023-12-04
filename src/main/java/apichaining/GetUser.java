package apichaining;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUser {

    @Test
    public void getUser(ITestContext iTestContext){
        int id= (Integer)iTestContext.getSuite().getAttribute("userid");
        String token = "e478b360415be8bca2a17f2a458e166c32a78dba8e9fdc97abbb21f6a83ee68c";
        given().headers("Authorization","Bearer "+token).
                pathParam("idName",id).
                when().get("https://gorest.co.in/public/v2/users/{id}").
                then().statusCode(200).log().all();
    }
}
