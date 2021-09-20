
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestDemoQA {

    public static Map<String, Object> jsonAsMapUser1 = new HashMap<>();
    public static Map<String, Object> jsonAsMapUser2 = new HashMap<>();

    @BeforeTest
    public void prepareLogin(){
        UserDTO user1 = new UserDTO("vzyd", "!Qwerty1");
        jsonAsMapUser1.put("userName", user1.getUserName());
        jsonAsMapUser1.put("password", user1.getPassward());

        UserDTO user2 = new UserDTO("user2", "qwerty");
        jsonAsMapUser2.put("userName", user2.getUserName());
        jsonAsMapUser2.put("password", user2.getPassward());
    }

    @Test
    public void checkGetBooks(){
        given().spec(getRequestSpec())
                .when().get("BookStore/v1/Books")
                .then().assertThat().statusCode(200).assertThat().body(Matchers.notNullValue())
                .assertThat().header("content-type", "application/json; charset=utf-8");
    }
    @Test
    public void checkAuthorizedUser1(){
        given().spec(getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapUser1)
                .when()
                .post("/Account/v1/Authorized")
                .then().assertThat().statusCode(200)
                .body(Matchers.is("true"));
    }

    @Test
    public void checNotAuthorizedUser(){
        given().spec(getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapUser2)
                .when()
                .post("/Account/v1/Authorized")
                .then().assertThat().statusCode(404)
                .body("message", equalTo("User not found!"));
    }

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().setBaseUri("https://demoqa.com/").setConfig(getConfig()).build();
    }

    public static RestAssuredConfig getConfig(){
        return RestAssuredConfig.newConfig();
    }
}
