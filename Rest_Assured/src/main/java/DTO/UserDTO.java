package DTO;

import org.apache.commons.lang3.RandomStringUtils;

public class UserDTO {
    private String userName;
    private String passward;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.passward = password;
    }

    public UserDTO() {
        this.userName = RandomStringUtils.randomAlphabetic(8);
        this.passward = "!Qwerty1";
    }

    public String getUserName() {
        return userName;
    }

    public String getPassward() {
        return passward;
    }
}
