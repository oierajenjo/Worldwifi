package Comun;

@SuppressWarnings("serial")
public class FicheroErrorException extends RuntimeException{
	
	public FicheroErrorException(String mensaje, Exception exception){
		super(mensaje, exception);
	}
	

}