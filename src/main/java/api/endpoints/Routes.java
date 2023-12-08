package api.endpoints;



//swagger url >//https://petstore.swagger.io/

//create user post>https://petstore.swagger.io/v2/user
//get user: https://petstore.swagger.io/v2/user/{username}
//update-put: https://petstore.swagger.io/v2/user/{username}
//delete:https://petstore.swagger.io/v2/user/{username}

public class Routes {

    public static String baseUrl = "https://petstore.swagger.io/v2";
    public static String postUrl = baseUrl+"user";
    public static String getUrl = baseUrl+"user/{username}";
    public static String putUrl = baseUrl+"user/{username}";
    public static String deleteUrl = baseUrl+"user{username}";

}
