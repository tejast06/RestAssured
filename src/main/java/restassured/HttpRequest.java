package restassured;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;



public class HttpRequest {

	// https://reqres.in/api/users/2 --single users - 200
	// https://reqres.in/api/users -- create -  201
//	{
//	    "name": "morpheus",
//	    "job": "leader"
//	}
	 
	// https://reqres.in/api/users/2 --put 200
	// https://reqres.in/api/users/2 --delete 204
	
	
	
//	@Test(priority = 1)
//	public void getUser() {
//
//
//
//		when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page",
//				equalTo("2")).log().all();
//	}

	@Test(priority = 2)
	public void createUser(){

		HashMap data = new HashMap();
		data.put("name","tejas");
		data.put("job","automationtester");


		//id:16
		given().contentType("application/json").body(data).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();

		//to fetch the id we need to use json path method
		when().post("https://reqres.in/api/users");
//				.jsonPath().getInt("id");

	}

	@Test(priority = 3)
	public void updateUser(){

		HashMap data = new HashMap();
		data.put("name","tejas");
		data.put("job","tester");


		//id:16
		given().contentType("application/json").body(data).when().post("https://reqres.in/api/users/16").then().statusCode(201).log().all();
	}

    @Test
    public void deleteUser(){
        when().delete("https://reqres.in/api/users/16").then().statusCode(204);
    }





	
	

	

}
