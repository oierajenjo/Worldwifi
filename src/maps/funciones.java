package maps;

import java.awt.geom.Point2D;
import java.io.*;
import java.net.MalformedURLException;
import maps.java.*;


public class funciones {
	
	/*
	 * Devuelve las coordenadas geográficas asociadas a la dirección postal enviada
	 */
	public static String getCoordenadas(String sitio){
		Geocoding ObjGeocod = new Geocoding();
		Point2D.Double resultadoCD = null;
		try {
			resultadoCD = ObjGeocod.getCoordinates(sitio);
		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}
		return resultadoCD.x + "," + resultadoCD.y;
	}
	
	public static void main(String[] args) {
		System.out.println(getCoordenadas("Bilbao, Ayuntamiento"));
	}
}
