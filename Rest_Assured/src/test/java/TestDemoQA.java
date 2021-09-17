import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestDemoQA {

    public static Map<String, Object> jsonAsMap = new HashMap<>();

    @BeforeTest
    public void prepareLogin(){
        jsonAsMap.put("userName", "vzyd");
        jsonAsMap.put("password", "!Qwerty1");
    }

    @Test
    public void checkGetBooks(){
        given().spec(getRequestSpec())
                .when().get("BookStore/v1/Books")
                .then().assertThat().statusCode(200).assertThat().body(Matchers.notNullValue())
                .assertThat().header("content-type", "application/json; charset=utf-8");
    }
    @Test
    public void checkAuthorized(){
        given().spec(getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMap)
                .when()
                .post("/Account/v1/Authorized")
                .then().assertThat().statusCode(200)
                .body(Matchers.is("true"));
    }

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().setBaseUri("https://demoqa.com/").setConfig(getConfig()).build();
    }

    public static RestAssuredConfig getConfig(){
        return RestAssuredConfig.newConfig();
    }
}
