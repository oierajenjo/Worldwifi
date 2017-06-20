package Comun;

@SuppressWarnings("serial")
public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String userName) {
        super("Incorrect password for user `" + userName + "`");
    }
}