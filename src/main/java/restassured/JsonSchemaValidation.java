package restassured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class JsonSchemaValidation {

    @Test
    public void validateSchema(){
        given().when().get("http://localhost:3000/data").
                then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
    }


}
