package Comun;

public class InvalidNameException extends Exception {
	 public InvalidNameException(String userName) {
	        super("Invalid username: `" + userName + "`");
	    }
}
