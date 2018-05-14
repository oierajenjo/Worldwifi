package maps;

import java.awt.geom.Point2D;
import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.http.protocol.HTTP;
//import com.google.maps.DirectionsApi;
//import com.google.maps.GeoApiContext;
//import com.google.maps.PlacesApi;
//import com.google.maps.model.DirectionsRoute;
//import com.google.maps.model.PlaceDetails;
//import com.google.maps.model.TravelMode;


import Comun.InvalidNameException;
import maps.java.*;


public class Funciones {
	/*
	 * Devuelve las coordenadas geográficas asociadas a la dirección postal enviada
	 */
	static String DIS_API_KEY = "AIzaSyBYkY-T5vBk-1uvs8lSrOuXNcqrjID65H0";
	static String DIR_API_KEY = "AIzaSyAyjcqYWIWpMqAjqedZbrOO70Wb96B-Z2Y";
	
	
	public static String getCoordenadas(String sitio){
		Geocoding ObjGeocod = new Geocoding();
		Point2D.Double resultadoCD = null;
		String Address = null;
		try {
			resultadoCD = ObjGeocod.getCoordinates(sitio);
			Address = ObjGeocod.getAddressFound();

		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}
		return Address + ": " + resultadoCD.x + "," + resultadoCD.y;
	}
	
	public static double getLongitud(String sitio){
		Geocoding ObjGeocod = new Geocoding();
		Point2D.Double resultadoCD = null;
		
		try {
			resultadoCD = ObjGeocod.getCoordinates(sitio);


		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}
		return resultadoCD.y;
	}
	
	public static double getLatitud(String sitio){
		Geocoding ObjGeocod = new Geocoding();
		Point2D.Double resultadoCD = null;
		
		try {
			resultadoCD = ObjGeocod.getCoordinates(sitio);


		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}
		return resultadoCD.x;
	}
	/*
	 * Devuelve el conjunto de direcciones postales asociadas al punto geográfico (latitude/longitude)
	 * Nos devuelve:
	 * 		Calle, nº, C.P. Ciudad, Pais
	 * 		Barrio, C.P. Ciudad, Pais
	 * 		Atoche, Ciudad, Pais
	 * 		Distrito, Ciudad, Pais
	 * 		Ciudad, Pais
	 * 		C.P. Ciudad, Pais
	 * 		Ciudad, Pais
	 * 		Área Metropolitalitana y Corredor del Henares, Ciudad, Pais
	 * 		Ciudad, Pais
	 * 		Provincio, Pais
	 * 		Pais
	 */
	public static String getDireccion(Double latitud, Double longitud){
		Geocoding ObjGeocod=new Geocoding();
		ArrayList<String> resultadoCI = null;
		String direccion = null;
		try {
			resultadoCI = ObjGeocod.getAddress(latitud,longitud);
			direccion = resultadoCI.get(0);
//			System.out.println( direccion );
//			for(String direccion:resultadoCI){
//				System.out.println(direccion);
//			}
		} catch (Exception InvalidName) {
				try {
					throw new InvalidNameException("Invalid lat: " + latitud + ", lon: " + longitud, InvalidName );
				} catch (InvalidNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return direccion;
	}
	public static String getBarrio(Double latitud, Double longitud) throws UnsupportedEncodingException, MalformedURLException{
		Geocoding ObjGeocod=new Geocoding();
		ArrayList<String> resultadoCI = null;
		String direccion= "";
		resultadoCI = ObjGeocod.getAddress(latitud,longitud);
		direccion = resultadoCI.get(3).split(",")[0];

//		for(String dir:resultadoCI){
//			direccion += dir + "\n";
//		}
		return direccion;
	}
	
	public static String getDistancia( String localizacion, ArrayList<String> direcciones){
		String destinos = "";
		for (String direccion:direcciones){
			destinos += direccion + "|";
			
		}
		destinos = destinos.replace(", ", ",");
		destinos = destinos.replace(" ", "+");
		localizacion = localizacion.replace(", ", ",");
		localizacion = localizacion.replace(" ", "+");
		String URL_DIST = "https://maps.googleapis.com/maps/api/distancematrix/json?units=km&origins="+ localizacion + "&destinations=" + destinos + "&key=" + DIS_API_KEY;
		
		return URL_DIST;
	}
	
	public static String getIndications( String localizacion, String direccion){
		direccion = direccion.replace(", ", ",");
		direccion = direccion.replace(" ", "+");
		localizacion = localizacion.replace(", ", ",");
		localizacion = localizacion.replace(" ", "+");
		String URL_DIR = "https://maps.googleapis.com/maps/api/directions/json?origin="+ localizacion + "&destination=" + direccion + "&key=" + DIR_API_KEY;
		return URL_DIR;
	}
	
//	public void getDirections() {
//
//        this.fromLatLngCurr = fromLatLngNew;
//        this.toLatLngCurr = toLatLngNew;
//        this.fromTitleCurr = fromTitleNew;
//        this.toTitleCurr = toTitleNew;
//
//        try {
//            calculatedRoutes = DirectionsApi.newRequest(context)
//                    .alternatives(true)
//                    .mode(TravelMode.WALKING)
//                    .origin(MapUtils.getModelLatLngFromGms(fromLatLngCurr))
//                    .destination(MapUtils.getModelLatLngFromGms(toLatLngCurr))
//                    .await();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        clearMarkersFromMap();
//        drawRouteMarkers();
//        updateBounds();
//
//    }
	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
		System.out.println(getCoordenadas("Bilbao, Ayuntamiento"));
		System.out.println("");
		System.out.println(getDireccion(43.2642276,-2.9234477));
		System.out.println("");
		System.out.println(getBarrio(getLatitud("Bilbao, Ayuntamiento"), getLongitud("Bilbao, Ayuntamiento")));
		ArrayList<String> lista = new ArrayList<>();
		lista.add(getDireccion(47.298208,-2.98245));
		lista.add(getDireccion(43.29048, -2.975375));
		System.out.println(getDistancia(getDireccion(43.2642276,-2.9234477), lista));
		System.out.println(getIndications(getDireccion(43.2642276,-2.9234477), getDireccion(43.29048, -2.975375)));
	}
}
