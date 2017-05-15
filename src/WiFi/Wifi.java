package WiFi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class Wifi {

	protected String nombre;
	protected String direccion;
	protected int intensidad;
	protected int altura;
	protected int longitud;

	public static void verRedesWifi() throws IOException {
		ArrayList<String>ssids=new ArrayList<String>();
		ArrayList<String>signals=new ArrayList<String>();
		ProcessBuilder builder1 = new ProcessBuilder( "cmd.exe", "/c","\"netsh wlan disconnect\"");
		ProcessBuilder builder2 = new ProcessBuilder( "cmd.exe", "/c","\"netsh wlan connect name=eduroam\"");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProcessBuilder builder = new ProcessBuilder( "cmd.exe", "/c","\"netsh wlan show all\"");
		builder.redirectErrorStream(true);
		Process a = builder1.start();
		Process b = builder2.start();
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		do {
		    line = r.readLine();
	    	if (line!=null) System.out.println("#" + line);
		    if (line == null)
		    	;
//		    	System.out.println("linea es null");
		    else if (line.contains("SSID")||line.contains("Signal")){
		        if(!line.contains("BSSID"))
		            if(line.contains("SSID")&&!line.contains("name")&&!line.contains("SSIDs"))
		            {
		                line=line.substring(8);
		                ssids.add(line);
		            }
		            if(line.contains("Signal"))
		            {
		                line=line.substring(30);
		                signals.add(line);

		            }

		            if(signals.size()==7)
		            {
		               // break;
		            }

		    }

		} while (line!=null);
		for (int i=0;i<ssids.size();i++)
		{
		    System.out.println("SSID name == "+ssids.get(i)+"   and its signal == "+signals.get(i)  );
		}
	}
	
	
	public double Distancia(){
//		int alturaUsuario = getAlturaUsuario();
//		int longitudUsuario = getLongituUsuario();
//		int alturaWifi = altura;
//		int longitudWifi = longitud;
//		
//		int alturaFinal = alturaWifi - alturaUsuario;
//		int longitudFinal = longitudWifi - longitudUsuario;
//		
//		double distancia = Math.sqrt(alturaFinal * alturaFinal + longitudFinal * longitudFinal);
//		
//		return distancia;
		return 0;
	}
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getIntensidad() {
		return intensidad;
	}



	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}



	public int getAltura() {
		return altura;
	}



	public void setAltura(int longitud) {
		this.altura = longitud;
	}



	public int getLongitud() {
		return longitud;
	}



	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}



	public Wifi(String nombre, int intensidad, int x, int y) {
		super();
		this.nombre = nombre;
		this.intensidad = intensidad;
		this.altura = x;
		this.longitud = y;
	}



	public static void main(String[] args) {
		System.out.println( "a");
		// TODO Auto-generated method stub
		try {
			System.out.println( "b");
			verRedesWifi();
			System.out.println( "c");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
