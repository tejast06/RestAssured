package apichaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DeleteUser {

    String token = "e478b360415be8bca2a17f2a458e166c32a78dba8e9fdc97abbb21f6a83ee68c";


    @Test
    public void deleteUser(ITestContext iTestContext){
        int id=(Integer)iTestContext.getSuite().getAttribute("userid");
        given().headers("Authorization","Bearer "+token).
                pathParam("idName",id).
                when().delete("https://gorest.co.in/public/v2/users/{idName}").
                then().statusCode(204).log().all();

    }
}
