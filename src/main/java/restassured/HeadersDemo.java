package restassured;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class HeadersDemo {

    //@Test
    public void testHeaders(){
        given().when().post("https://www.google.com").
                then().header("Content-Type","text/html; charset=ISO-8859-1");
    }

    @Test
    public void getHeaders(){
     Response res =  given().when().post("https://www.google.com");

       Headers header =  res.getHeaders();
       for(Header h :header){
           System.out.println(h.getName() +"   "+ h.getValue());
       }

    }
}
