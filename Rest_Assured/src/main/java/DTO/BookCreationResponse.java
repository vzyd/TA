package DTO;

import java.util.HashMap;
import java.util.List;

public class BookCreationResponse {
    private List<HashMap<String, String>> books;


    public List<HashMap<String, String>> getBooks() {
        return books;
    }

    public void setBooks(List<HashMap<String, String>> books) {
        this.books = books;
    }

}
