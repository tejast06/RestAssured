package api.test;

import api.endpoints.Routes;
import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    Faker faker;
    User user;

    public void setUpData(){

        faker = new Faker();
        user = new User();
        user.setId(faker.idNumber().hashCode());
        user.setUserName(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setPassword(faker.internet().password(5,10));
        user.setPhone(faker.phoneNumber().cellPhone());

    }

    @Test(priority = 1)
    public void testPostUser(){
        user = new User();
       Response response =  UserEndPoints.createUser(user);
       response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 2)
    public void testGetUser(){
       Response response = UserEndPoints.getUser(this.user.getUserName());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUser(){
        user.setUserName(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user = new User();
       Response response =  UserEndPoints.updateUser(this.user.getUserName(),user);
       response.then().log().all();
       Assert.assertEquals(response.statusCode(),201);

       //checking data after update:
      Response responseAfterUpdate =   UserEndPoints.getUser(this.user.getUserName());
        Assert.assertEquals(responseAfterUpdate.statusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUser(){
       Response response =  UserEndPoints.deleteUser(this.user.getUserName());
       Assert.assertEquals(response.statusCode(),200);
    }
}
