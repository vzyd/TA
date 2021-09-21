import java.util.List;


public class UserCreationResponse {
    private String userID;
    private  String username;
    private List<String>  books;

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}

