package Comun;

@SuppressWarnings("serial")
public class NewUserExistsException extends Exception {
    public NewUserExistsException(String userName) {
        super("User `" + userName + "` already exists.");
    }
}