
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class TestUsers {

    public static Map<String, Object> jsonAsMapNewUser = new HashMap<>();
    public static Map<String, Object> jsonAsMapUser1 = new HashMap<>();
    public static Map<String, Object> jsonAsMapUser2 = new HashMap<>();
    public static Map<String, Object> jsonAsMapUser3 = new HashMap<>();

    @BeforeTest
    public void prepareLogin() {

        UserDTO newUser = new UserDTO("userDemo", "?Demo1234");
        jsonAsMapNewUser.put("userName", newUser.getUserName());
        jsonAsMapNewUser.put("password", newUser.getPassward());

        UserDTO user1 = new UserDTO("vzyd", "!Qwerty1");
        jsonAsMapUser1.put("userName", user1.getUserName());
        jsonAsMapUser1.put("password", user1.getPassward());

        UserDTO user2 = new UserDTO("unautorized", "qwerty");
        jsonAsMapUser2.put("userName", user2.getUserName());
        jsonAsMapUser2.put("password", user2.getPassward());

        UserDTO user3 = new UserDTO("user3", "!Qwerty1");
        jsonAsMapUser3.put("userName", user3.getUserName());
        jsonAsMapUser3.put("password", user3.getPassward());

    }

    @Test(enabled = false)
    public void checkGetUser() {
        given().spec(BaseSettings.getRequestSpec())
                .when().get("Account/v1/User/5c3b801c-9387-4330-b226-ea65aa109a82")
                .then().assertThat().statusCode(200)
                .assertThat().body("username", equalTo("user3"));
    }

    @Test(enabled = false)
    public void checkDelUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapUser3)
                .when()
                .post("/Account/v1/User/5c3b801c-9387-4330-b226-ea65aa109a82")//id for user3
                .then().assertThat().statusCode(200);
    }


    @Test
    public void checkAddNewUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapNewUser)
                .when()
                .post("Account/v1/User")
                .then().assertThat().statusCode(201)
                .body("username", equalTo("userDemo"));
    }


    @Test
    public void checkAuthorizedUser1() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapUser1)
                .when()
                .post("/Account/v1/Authorized")
                .then().assertThat().statusCode(200)
                .body(Matchers.is("true"));
    }

    @Test
    public void checNotAuthorizedUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapUser2)
                .when()
                .post("/Account/v1/Authorized")
                .then().assertThat().statusCode(404)
                .body("message", equalTo("User not found!"));
    }
}



