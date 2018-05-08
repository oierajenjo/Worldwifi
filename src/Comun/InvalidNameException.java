package Comun;

@SuppressWarnings("serial")
public class InvalidNameException extends Exception {
	 public InvalidNameException(String mensaje, Exception e) {
	        super(mensaje, e);
	    }
}
