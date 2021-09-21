import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestBooks {


    public static Map<String, Object> userBook = new HashMap<>();


    @BeforeTest
    public void prepareLogin() {
        userBook.put("userId", "5c3b801c-9387-4330-b226-ea65aa109a82");
        userBook.put("isbn", "9781449365035");


    }

    @Test
    public void checkGetBooks() {

        given().spec(BaseSettings.getRequestSpec())
                .when().get("BookStore/v1/Books")
                .then().assertThat().statusCode(200)
                .assertThat().body("books[0].title", equalTo("Git Pocket Guide"));
    }

    @Test
    public void checkGetBook() {
        given().spec(BaseSettings.getRequestSpec())
                .when().get("BookStore/v1/Book?ISBN=9781449331818")
                .then().assertThat().statusCode(200)
                .assertThat().body("title", equalTo("Learning JavaScript Design Patterns"));
    }


    @Test(enabled = false)
    public void checkChangeIsbnInUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(userBook)
                .when().put("BookStore/v1/Books/9781491950296")
                .then().assertThat().statusCode(200)
                .body("books[2].isbn", equalTo("9781449365035"));
    }

    @Test
    public void checkDelBook() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(userBook)
                .when()
                .delete("BookStore/v1/Book")
                .then().assertThat().statusCode(401)
                .body("message", equalTo("User not authorized!"));
    }

    @Test
    public void checkAddUserBooks() {
        String jsonRequest = "{\n" +
                                "\"userId\": \"user3\",\n" +
                                "\"collectionOfIsbns\": [ \n" +
                                    "{\n" +
                                        " \"isbn\": \"9781449365035\" \n" +
                                      "}\n" +
                                  " ]\n" +
                               "}\n";
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(jsonRequest)
                .when()
                .post("BookStore/v1/Books")
                .then().assertThat().statusCode(401)
                .body("message", equalTo("User not authorized!"));
    }


}

