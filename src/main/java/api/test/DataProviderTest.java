package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(priority = 1,dataProvider = "data",dataProviderClass = DataProviders.class)
    public void testPostReq(String userID,String UserName,String FirstName,String LastName,String Email, String Password,String Phone){
        User user = new User();
        user.setId(Integer.parseInt(userID));
        user.setUserName(UserName);
        user.setFirstName(FirstName);
        user.setLastName(LastName);
        user.setEmail(Email);
        user.setPassword(Password);
        user.setPhone(Phone);

         Response response =  UserEndPoints.createUser(user);
         Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 1,dataProvider = "username",dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName){
         Response response =  UserEndPoints.deleteUser(userName);
         Assert.assertEquals(response.statusCode(),200);
    }


}
