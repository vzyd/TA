package DTO;

import org.apache.commons.lang3.RandomStringUtils;

public class UserDTO {
    private String userName;
    private String password;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserDTO() {
        this.userName = RandomStringUtils.randomAlphabetic(8);
        this.password = "!Qwerty1";
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
