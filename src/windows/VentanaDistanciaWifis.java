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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		String[][] datos = null;
		for (int i = 0; i < arrayDistancias.size(); i++) {
			datos[i][0] = arrayDistancias.get(i).getDestino();
			datos[i][1] = arrayDistancias.get(i).getkmTexto();
			datos[i][2] = arrayDistancias.get(i).gettimeTexto();
		}
		//Se crea una tabla con tres huecos uno destino, otro tiempo y otro distancia
		//arrayDistancias.size();
		String[] cols= {"Destino", "Tiempo", "Distancia"};
		DefaultTableModel model = new DefaultTableModel(datos, cols);
		JTable jTabla = new JTable(model);

		
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
