package restassured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingXMLResponse {

    //@Test
    public void validateXML1(){
        given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1").
                then().statusCode(200).
                header("Content-Type","application/xml; charset=utf-8").
                body("TravelerinformationResponse.page",equalTo("1")).
                body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
    }

    //@Test
    public void validateXML2(){

        Response response =  given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.header("Content-Type"),"application/xml; charset=utf-8");

        String page =   response.xmlPath().get("TravelerinformationResponse.page").toString();
        Assert.assertTrue(page.contains("2"));

        String name =  response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
        Assert.assertTrue(name.contains("Developer"));
    }

    @Test
    public void validateXML3(){

        Response response =  given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
        XmlPath xmlPath = new XmlPath(response.asString());

        //total number of traveler information
        List<String> list =  xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
        Assert.assertEquals(list.size(),10);

        boolean status = false;
        List<String> names =  xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
        for(int i=0; i< names.size(); i++){
            if(names.equals("Developer")){
                status =  true;
                break;
            }
        }
        Assert.assertEquals(status,true);

    }


}
