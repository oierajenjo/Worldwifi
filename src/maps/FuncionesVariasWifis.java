package maps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import maps.Funciones;
import windows.Ubicacion;


public class FuncionesVariasWifis {

//	https://maps.googleapis.com/maps/api/distancematrix/json?units=km&mode=walking&origins=40.6655101,-73.89188969999998&destinations=40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626&key=AIzaSyBYkY-T5vBk-1uvs8lSrOuXNcqrjID65H0
	public static ArrayList<Distance> getDistanciasTotalFromJson(URL url_dis) {
		ArrayList<Distance> distancias = new ArrayList<Distance>();
		try {
			
			JSONObject json = Funciones.readJsonFromUrl(url_dis);
			JSONArray arr_des = json.getJSONArray("destination_addresses");
			JSONArray arr_dis = json.getJSONArray("elements");
			for(int i = 0; i < arr_des.length(); i++) {
				Distance distancia = new Distance(null, 0, 0, null, null);
				distancia.setDestino(arr_des.get(i).toString());
				distancia.setDis_m(arr_dis.getJSONObject(i).getJSONObject("distance").getInt("value"));
				distancia.setDis_seg(arr_dis.getJSONObject(i).getJSONObject("duration").getInt("value"));
				distancia.setkmTexto(arr_dis.getJSONObject(i).getJSONObject("distance").getString("text"));
				distancia.settimeTexto(arr_dis.getJSONObject(i).getJSONObject("duration").getString("text"));
				distancias.add(distancia);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(distancias, Comparator.comparingInt(Distance::getDis_m));
		return distancias;		
	}
	
	public static URL getURLIndicacion (Ubicacion origen, Ubicacion destino) throws MalformedURLException {
		
		String origenS = origen.getDireccion();
		origenS = origenS.replace(", ", ",");
		origenS = origenS.replace(" ", "+");
		String destinoS = origen.getDireccion();
		destinoS = destinoS.replace(", ", ",");
		destinoS = destinoS.replace(" ", "+");
		
		String urlS = "https://www.google.com/maps/dir/?api=1&origin="+ origenS +"&destination=" + destinoS +"&travelmode=walking";
		URL url = new URL(urlS);
		return url;
	}
	
	
}
