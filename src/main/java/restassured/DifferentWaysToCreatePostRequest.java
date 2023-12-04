package restassured;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class DifferentWaysToCreatePostRequest {

    //using hashmap
    //@Test(priority = 1)
    public void usingHashMap(){
        HashMap data = new HashMap();
        data.put("Name","Tejas");
        data.put("Location","Mumbai");

        given().contentType("application/json").body(data).when().post("http://localhost:3000/data").
                then().statusCode(201).body("Name",equalTo("Tejas")).
                body("Location",equalTo("Mumbai"));
    }

    //@Test(priority = 1)
    public void usingJsonOrg(){
        JSONObject object = new JSONObject();
        object.put("Name","toley");
        object.put("Location","cdcdcd");

        given().contentType("application/json").body(object.toString()).when().post("http://localhost:3000/data").
                then().statusCode(201).body("Name",equalTo("Tejas")).
                body("Location",equalTo("Mumbai"));
    }

    //@Test(priority = 1)
    public void usingPojoRequest(){
        CreateDataWithPojoRequest pr = new CreateDataWithPojoRequest();
        pr.setName("Tejas");
        pr.setLOcation("Mumbai");

        given().contentType("application/json").body(pr).when().post("http://localhost:3000/data").
                then().statusCode(201).body("Name",equalTo("Tejas")).
                body("Location",equalTo("Mumbai"));
    }

    @Test(priority = 1)
    public void usingExternalJSONFile() throws FileNotFoundException {

        File file = new File(".\\file.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);


        given().contentType("application/json").body(jo.toString()).when().post("http://localhost:3000/data").
                then().statusCode(201).body("Name",equalTo("Tejas")).
                body("Location",equalTo("Mumbai"));
    }

    //@Test
    public void delete(){
        given().when().delete("http://localhost:3000/data/4").then().statusCode(200);
    }
}
