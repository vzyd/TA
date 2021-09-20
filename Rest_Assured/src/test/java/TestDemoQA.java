
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Configuration;
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


public class TestDemoQA {

    public static Map<String, Object> jsonAsMapUser1 = new HashMap<>();
    public static Map<String, Object> jsonAsMapUser2 = new HashMap<>();

    public static Map<String, Object> book = new HashMap<>();



    @BeforeTest
    public void prepareLogin() {
        UserDTO user1 = new UserDTO("vzyd", "!Qwerty1");
        jsonAsMapUser1.put("userName", user1.getUserName());
        jsonAsMapUser1.put("password", user1.getPassward());

        UserDTO user2 = new UserDTO("user3", "!Qwerty1");
        jsonAsMapUser2.put("userName", user2.getUserName());
        jsonAsMapUser2.put("password", user2.getPassward());
        jsonAsMapUser2.put("isbn", "9781449325862");
        jsonAsMapUser2.put("userId","5c3b801c-9387-4330-b226-ea65aa109a82");





    }

    @Test(enabled = false)
    public void checkGetUser(){
        given().spec(BaseSettings.getRequestSpec())
                .when().get("Account/v1/User/5c3b801c-9387-4330-b226-ea65aa109a82")
                .then().assertThat().statusCode(200)
                .assertThat().body("username", equalTo("user3"));
    }

   @Test(enabled = false)
   public void checkDelUser(){
       given().spec(BaseSettings.getRequestSpec())
               .header("content-type", "application/json")
               .body(jsonAsMapUser2)
               .when()
               .post("/Account/v1/User/5c3b801c-9387-4330-b226-ea65aa109a82")//id for user3
               .then().assertThat().statusCode(200);
   }


    @Test
   public void checkAddNewUser(){
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapUser2)
                .when()
                .post("Account/v1/User")
                .then().assertThat().statusCode(201)
                .body("username", equalTo("user5"));
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

//////////////////////////////////////////////////////////////////////////////


    @Test
    public void checkGetBooks() {

        given().spec(BaseSettings.getRequestSpec())
                .when().get("BookStore/v1/Books")
                .then().assertThat().statusCode(200)
                .assertThat().body("books[0].title", equalTo("Git Pocket Guide"));
    }

    @Test
    public void checkGetBook(){
        given().spec(BaseSettings.getRequestSpec())
                .when().get("BookStore/v1/Book?ISBN=9781449331818")
                .then().assertThat().statusCode(200)
                .assertThat().body("title", equalTo("Learning JavaScript Design Patterns"));
    }

//    @Test
//    public void checkAddBooks(){
//        Object document = Configuration.defaultConfiguration().jsonProvider().parse("""{
//                                                                                         "userId": "5c3b801c-9387-4330-b226-ea65aa109a82",
//                                                                                         "collectionOfIsbns": [
//                                                                                           {
//                                                                                             "isbn": "9781449325862"
//                                                                                           },
//                                                                                           {
//                                                                                             "isbn": "9781449331818"
//                                                                                           }
//                                                                                         ]
//                                                                                       }""");
//        given().spec(BaseSettings.getRequestSpec())
//                .header("content-type", ContentType.JSON, "Accept", ContentType.JSON)
//                .body(""{
//                        "userId": "5c3b801c-9387-4330-b226-ea65aa109a82",
//                        "collectionOfIsbns": [
//                                {
//                                     "isbn": "9781449325862"
//                                 },
//                        {
//                            "isbn": "9781449331818"
//                      }
//                         ]
//                            }"""
//                   )
//                .when()
//                .post("/Account/v1/Authorized")
//                .then().assertThat().statusCode(404)
//                .body("message", equalTo("User not found!"));
//    }

    @Test
    public void checkDelBook(){
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonAsMapUser2)
                .when()
                .delete("/BookStore/v1/Book")
                .then().assertThat().statusCode(401)
                .body("message", equalTo("User not authorized!"));
    }


}