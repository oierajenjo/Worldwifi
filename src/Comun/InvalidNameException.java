package Comun;

@SuppressWarnings("serial")
public class InvalidNameException extends Exception {
	 public InvalidNameException(String userName) {
	        super("Invalid username: `" + userName + "`");
	    }
}
