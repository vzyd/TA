public class UserDTO {
    private String userName;
    private String passward;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.passward = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassward() {
        return passward;
    }
}
