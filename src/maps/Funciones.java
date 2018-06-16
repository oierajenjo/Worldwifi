package maps;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.*;


import Comun.InvalidNameException;
import WiFi.Wifi;
import maps.java.*;


public class Funciones {
	/*
	 * Devuelve las coordenadas geográficas asociadas a la dirección postal enviada
	 */
	static String DIS_API_KEY = "AIzaSyBYkY-T5vBk-1uvs8lSrOuXNcqrjID65H0";
	static String DIR_API_KEY = "AIzaSyAyjcqYWIWpMqAjqedZbrOO70Wb96B-Z2Y";


	//	public static String getCoordenadas(String sitio){
	//		Geocoding ObjGeocod = new Geocoding();
	//		Point2D.Double resultadoCD = null;
	//		String Address = null;
	//		try {
	//			resultadoCD = ObjGeocod.getCoordinates(sitio);
	//			Address = ObjGeocod.getAddressFound();
	//
	//		} catch (UnsupportedEncodingException | MalformedURLException e) {
	//			e.printStackTrace();
	//		}
	//		return Address + ": " + resultadoCD.x + "," + resultadoCD.y;
	//	}

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

	public static String getDireccionConLaLo(Double latitud, Double longitud){
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
				e.printStackTrace();
			}
		}
		return direccion;
	}


	public static String getDireccionConTexto(String sitio){
		Geocoding ObjGeocod = new Geocoding();
		ArrayList<String> resultadoCI = null;
		String direccion = null;
		try {
			resultadoCI = ObjGeocod.getAddress(getLatitud(sitio), getLongitud(sitio));
			direccion = resultadoCI.get(0);
			//			System.out.println( direccion );
			//			for(String direccion:resultadoCI){
			//				System.out.println(direccion);
			//			}
		} catch (Exception InvalidName) {
			try {
				throw new InvalidNameException("Invalid direction: " + sitio, InvalidName );
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return direccion;
	}

	//	public static String getBarrio(Double latitud, Double longitud) throws UnsupportedEncodingException, MalformedURLException{
	//		Geocoding ObjGeocod=new Geocoding();
	//		ArrayList<String> resultadoCI = null;
	//		String direccion= "";
	//		resultadoCI = ObjGeocod.getAddress(latitud,longitud);
	//		direccion = resultadoCI.get(3).split(",")[0];
	//
	//		//		for(String dir:resultadoCI){
	//		//			direccion += dir + "\n";
	//		//		}
	//		return direccion;
	//	}

	public static String getDistanciasURL( String localizacion, ArrayList<Wifi> wifis){
		String destinos = "";
		Double latitud = null;
		Double longitud = null;
		for (Wifi wifi:wifis){
			latitud = wifi.getLatitud();
			longitud = wifi.getLongitud();
			destinos = destinos + latitud + "%2C" + longitud;
			//			for (int i = 0; i < wifis.size(); i++) {
			destinos = destinos + "%7C";
			//			}
		}
		localizacion = localizacion.replace(", ", ",");
		localizacion = localizacion.replace(" ", "+");
		String URL_DIST = "https://maps.googleapis.com/maps/api/distancematrix/json?units=km&mode=walking&origins="+ localizacion + "&destinations=" + destinos + "&key=" + DIS_API_KEY;

		return URL_DIST;
	}

//	public static String getDistanciasFromJson( JSONObject json){
//		String destinos = "";
//		Double latitud = null;
//		Double longitud = null;
//
//		return ;
//	}

	//	Saca una json de la url
	public static JSONObject readJsonFromUrl(URL url) throws IOException, JSONException {
		InputStream is = url.openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	//	Sacar un Array del desde el un origen y destino
	public static ArrayList<Indicacion> getIndicaciones(String origen, String destino){
		ArrayList<Indicacion> indicaciones = new ArrayList<Indicacion>(); 
		Route ObjRout=new Route();
		try {
			String[][] resultado = ObjRout.getRoute(origen, destino, null, Boolean.TRUE, Route.mode.walking, Route.avoids.nothing);
			for(int i=0; i<resultado.length; i++){
				Indicacion indicacion = new Indicacion(resultado[i][0], resultado[i][1], resultado[i][2], resultado[i][3], resultado[i][4]);
				indicaciones.add(indicacion);
			}
			return indicaciones;
		} catch (Exception e) {
			return null;
		}
	}

	//Calculos desde un arraylist de indicaciones
	public static String getTimeFromArray (ArrayList<Indicacion> indicaciones, int i) {
		return indicaciones.get(i).getTiempo();
	}
	public static String getDistanciaFromArray (ArrayList<Indicacion> indicaciones, int i) {
		return indicaciones.get(i).getDistancia();
	}
	public static String getLaFromArray (ArrayList<Indicacion> indicaciones, int i) {
		return indicaciones.get(i).getLa();
	}
	public static String getLoFromArray (ArrayList<Indicacion> indicaciones, int i) {
		return indicaciones.get(i).getLo();
	}
	public static String getDescFromArray (ArrayList<Indicacion> indicaciones, int i) {
		return indicaciones.get(i).getDescripcion();
	}

	//   
	//	public static String getIndications( String localizacion, String direccion){
	//		direccion = direccion.replace(", ", ",");
	//		direccion = direccion.replace(" ", "+");
	//		localizacion = localizacion.replace(", ", ",");
	//		localizacion = localizacion.replace(" ", "+");
	//		String URL_DIR = "https://maps.googleapis.com/maps/api/directions/json?origin="+ localizacion + "&destination=" + direccion + "&key=" + DIR_API_KEY;
	//		return URL_DIR;
	//	}

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


	//	public static int Distancia (String origen, String destino) {
	//		String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origen+"&destinations="+destino+"&key="+ API_KEY;
	//        Request request = new Request.Builder()
	//            .url(url)
	//            .build();
	//
	//        Response response = client.newCall(request).execute();
	//        return response.body().string();
	//      }


	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
		//		System.out.println(getCoordenadas("Bilbao, Ayuntamiento"));
		System.out.println("");
		System.out.println(getDireccionConLaLo(43.2642276, -2.9234477));
		System.out.println("");
		//		System.out.println(getBarrio(getLatitud("Bilbao, Ayuntamiento"), getLongitud("Bilbao, Ayuntamiento")));
		ArrayList<String> lista = new ArrayList<>();
		lista.add(getDireccionConLaLo(47.298208, -2.98245));
		lista.add(getDireccionConLaLo(43.29048, -2.975375));
		//		System.out.println(getDistancia(getDireccion(43.2642276,-2.9234477), lista));
		//		System.out.println(getIndications(getDireccion(43.2642276,-2.9234477), getDireccion(43.29048, -2.975375)));
	}
}
