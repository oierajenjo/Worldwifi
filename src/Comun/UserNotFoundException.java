package Comun;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String userName) {
        super("User `" + userName + "` not found.");
    }
}