
import DTO.BookCreationResponse;
import DTO.UserCreationResponse;
import DTO.UserDTO;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Tests {

    private static Map<String, Object> userLogin = new HashMap<>();
    private String userID;

    private List<HashMap<String, String>> books;


    @BeforeTest
    public void prepareLogin() {

        UserDTO newUser = new UserDTO();
        userLogin.put("userName", newUser.getUserName());
        userLogin.put("password", newUser.getPassword());

        UserCreationResponse userCreationResponse = createUser();
        userID = userCreationResponse.getUserID();

        authorizeUser();

        BookCreationResponse bookCreationResponse = getBooks();
        books = bookCreationResponse.getBooks();

    }


    private UserCreationResponse createUser() {
       return given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(userLogin)
                .log().all()
                .when()
                .post("Account/v1/User")
                .then()
                .log().all()
                .statusCode(201)
                .extract().response().as(UserCreationResponse.class);
    }

    private void authorizeUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(userLogin)
                .log().all()
                .when()
                .post("Account/v1/GenerateToken")
                .then()
                .log().all()
                .statusCode(200);
    }

    private BookCreationResponse getBooks() {
        return given().spec(BaseSettings.getRequestSpec())
                .when().get("BookStore/v1/Books")
                .then().statusCode(200)
                .log().all()
                .extract().response().as(BookCreationResponse.class);
    }

    /*User tests*/
    @Test
    public void checkAuthorizedUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(userLogin)
                .when()
                .post("/Account/v1/Authorized")
                .then().assertThat().statusCode(200)
                .body(Matchers.is("true"));
    }

    @Test(enabled = true)
    public void checkGetUser() {
        given().spec(BaseSettings.getRequestSpec())
                .when().get("Account/v1/User/" + userID)
                .then().assertThat().statusCode(200)
                .assertThat().body("username", equalTo(userLogin.get("userName")));
    }

    @Test(enabled = true)
    public void checkDelUser() {
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .when()
                .log().all()
                .delete("/Account/v1/User/" + userID)
                .then().assertThat().statusCode(200);
    }

    /*Books tests*/
    @Test
    public void checkGetBook(){
        given().spec(BaseSettings.getRequestSpec())
                .when().get("BookStore/v1/Book?ISBN=" + books.get(0).get("isbn"))
                .then().assertThat().statusCode(200)
                .assertThat().body("title", equalTo(books.get(0).get("title")));
    }

    @Test(enabled = true)
    public void checkAddListOfUserBooks() {
        String addBooksRequest = "{\n" +
                "\"userId\": \"" +userID + "\",\n" +
                "\"collectionOfIsbns\": [ \n" +
                "{\n" +
                " \"isbn\": \"" + books.get(0).get("isbn") + "\" \n" +
                "}\n" +
                " ]\n" +
                "}\n";
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .log().all()
                .body(addBooksRequest)
                .when()
                .log().all()
                .post("BookStore/v1/Books")
                .then().assertThat().statusCode(201);
               // .body("message", equalTo("User not authorized!"));
    }

    @Test(enabled = true)
    public void checkChangeIsbnInUser(){
        String replaceIsbnRequest = "{\n" +
                "\"userId\": \"" +userID + "\",\n" +
                " \"isbn\": \"" + books.get(4).get("isbn") + "\" \n" +
                "}\n";
        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .log().all()
                .body(replaceIsbnRequest)
                .when()
                .log().all()
                .put("BookStore/v1/Books/" + books.get(0).get("isbn"))
                .then().assertThat().statusCode(200)
                .body("books[0].isbn", equalTo(books.get(4).get("isbn")));
    }

    @Test(enabled = true)
    public void checkDelBook(){
        String deleteBookRequest = "{\n" +
                "\"userId\": \"" +userID + "\",\n" +
                " \"isbn\": \"" + books.get(0).get("isbn") + "\" \n" +
                "}\n";

        given().spec(BaseSettings.getRequestSpec())
                .header("content-type", "application/json")
                .body(deleteBookRequest)
                .when()
                .delete("BookStore/v1/Book")
                .then().assertThat().statusCode(204);
                //.body("message", equalTo("User not authorized!"));
    }

}



