package windows;

import java.awt.BorderLayout;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BD.neo4j.Neo4j;
import WiFi.Wifi;
import maps.Distance;
import maps.Funciones;
import maps.FuncionesVariasWifis;

public class VentanaDistanciaWifis extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaDistanciaWifis(Ubicacion u) throws UnsupportedEncodingException, MalformedURLException{
		setSize (800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		ArrayList<Wifi> wifiCercanas = new ArrayList<>();
		String ciudad = Funciones.getCiudad(u.getDireccion());
		wifiCercanas = Neo4j.conseguirWifis(ciudad);
		ArrayList<Distance> arrayDistancias= FuncionesVariasWifis.getDistanciasTotalFromJson(new URL(Funciones.getDistanciasURL(Inicial.getTuUbicacion().getDireccion(), wifiCercanas)));
		//Se crea una tabla con tres huecos uno destino, otro tiempo y otro distancia
		//arrayDistancias.size();
		
		for (int i = 1; i <= arrayDistancias.size(); i++) {
			arrayDistancias.get(i).getDestino();
			arrayDistancias.get(i).getkmTexto();
			arrayDistancias.get(i).gettimeTexto();
		}
		//		System.out.println(ciudad);
		//		for (Wifi w : wifiCercanas){
		//			ArrayList<Distance> distancias =  new ArrayList<>();
		//			Ubicacion uWifi = new Ubicacion();
		//			uWifi.setLatitud(w.getLatitud());
		//			uWifi.setLongitud(w.getLongitud());
		//			URL url = FuncionesVariasWifis.getURLIndicacion(u, uWifi);
		////			Distance d = FuncionesVariasWifis.getDistanciasTotalFromJson(url);
		//		}


		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


			}
		});

		JButton btnVolver = new JButton("Volver");
		panel_1.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccion v = new VentanaSeleccion(u);
				v.setVisible(true);
				dispose();

			}
		});


	}

}
