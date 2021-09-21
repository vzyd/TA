
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class TestUsers {

    private static Map<String, Object> jsonAsMapNewUser = new HashMap<>();
    private String userID;

    @Test
    public void prepareLogin() {

        UserDTO newUser = new UserDTO();
        jsonAsMapNewUser.put("userName", newUser.getUserName());
        jsonAsMapNewUser.put("password", newUser.getPassward());



        UserCreationResponse userCreationResponse = createUser();


        userID = userCreationResponse.getUserID();



    }

    private UserCreationResponse createUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapNewUser)
                .log().all()
                .when()
                .post("Account/v1/User")
                .then()
                .log().all()
                .statusCode(201)
                .extract().response().as(UserCreationResponse.class);
    }

    @Test(enabled = false)
    public void checkGetUser() {
        given().spec(BaseSettings.getRequestSpec())
                .when().get("Account/v1/User/" + userID)
                .then().assertThat().statusCode(200)
                .assertThat().body("username", equalTo("user3"));
    }

//    @Test(enabled = false)
//    public void checkDelUser() {
//        given().spec(BaseSettings.getRequestSpec())
//                .header("content-type", "application/json")
//               // .body(jsonAsMapUser3)
//                .when()
//                .post("/Account/v1/User/" + userID)//id for user3
//                .then().assertThat().statusCode(200);
//    }
//
//
//    @Test
//    public void checkAddNewUser() {
//        given().spec(BaseSettings.getRequestSpec())
//                .header("content-type", "application/json")
//                .body(jsonAsMapNewUser)
//                .log().all()
//                .when()
//                .post("Account/v1/User")
//                .then().assertThat().statusCode(201)
//                .log().all()
//                .body("username", equalTo("userDemo2"));
//    }
//
//
//    @Test
//    public void checkAuthorizedUser1() {
//        given().spec(BaseSettings.getRequestSpec())
//                .header("content-type", "application/json")
//                .body(jsonAsMapNewUser)
//                .when()
//                .post("/Account/v1/Authorized")
//                .then().assertThat().statusCode(200)
//                .body(Matchers.is("true"));
//    }
//
//    @Test
//    public void checNotAuthorizedUser() {
//        given().spec(BaseSettings.getRequestSpec())
//                .header("content-type", "application/json")
//                .body(jsonAsMapUser2)
//                .when()
//                .post("/Account/v1/Authorized")
//                .then().assertThat().statusCode(404)
//                .body("message", equalTo("User not found!"));
//    }
}



