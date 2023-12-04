package restassured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestParsingResponse {

    @Test
    public void testParsingData(){

        //approach1
//        given().contentType("application/json").when().get("http://localhost:3000/data").
//                then().body("data[2].Location",equalTo("Los Angeles"));

        //approach2
//      Response res =  given().contentType("application/json").when().get("http://localhost:3000/data");
//      Assert.assertEquals(res.getStatusCode(),"200");

        Response res =  given().contentType(ContentType.JSON).when().get("http://localhost:3000/data");
        JSONObject jo = new JSONObject(res.asString()); //converting response into json object


        boolean status = false;
        for(int i=0; i<jo.getJSONArray("data").length(); i++){
          String location =   jo.getJSONArray("data").getJSONObject(i).get("Location").toString();
          System.out.println(location);
          if(location.equals("New York")){
              status=true;
              break;
          }
        }


    }
}
