package restassured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class TestCookies {

    //@Test
    public void validateCookies(){
      Response res =  given().when().post("https://www.google.com");
//      String cookieVal =  res.getCookie("NID");
//      System.out.println(cookieVal);

       Map<String,String> cookies =  res.getCookies();

       for(String c :cookies.keySet()){
           String s = res.getCookie(c);
           System.out.println(c +"  "+ s);
       }

    }


}
