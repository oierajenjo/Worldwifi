package windows;

import java.awt.BorderLayout;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import WiFi.Wifi;
import maps.Distance;
import maps.Funciones;
import maps.FuncionesVariasWifis;

public class VentanaDistanciaWifis extends JFrame {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	public VentanaDistanciaWifis(Ubicacion u) throws UnsupportedEncodingException, MalformedURLException{
		setSize (800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		ArrayList<Wifi> wifisCercanas = new ArrayList<Wifi>();
		wifisCercanas = Inicial.getListaWifis();
		ArrayList<Distance> arrayDistancias = null;
		for(Wifi wifi: wifisCercanas) {
			System.out.println(wifi.toString());
			URL url = Funciones.getDistanciaURL(u.getLatitud(), u.getLongitud(), wifi);
			Distance distancia = FuncionesVariasWifis.getDistanciaTotalFromJson(url);
			arrayDistancias.add(distancia);
		}
		Collections.sort(arrayDistancias, Comparator.comparingInt(Distance::getDis_m));
		String[][] datos = null;
		for (int i = 0; i < 10; i++) {
			datos[i][0] = arrayDistancias.get(i).getDestino().toString();
			datos[i][1] = arrayDistancias.get(i).getkmTexto().toString();
			datos[i][2] = arrayDistancias.get(i).gettimeTexto().toString();
		}
		System.out.println(datos);
		//Se crea una tabla con tres huecos uno destino, otro tiempo y otro distancia
		//arrayDistancias.size();
		String[] cols= {"Destino", "Tiempo", "Distancia"};
		DefaultTableModel model = new DefaultTableModel(datos, cols);
		JTable jTabla = new JTable(model);
		panel.add(jTabla);
		
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
				Ubicacion u2 = new Ubicacion();
				int i = jTabla.getSelectedRow();
				String dir = (String) jTabla.getModel().getValueAt(i, 0);
				u2.setDireccion(Funciones.getDireccionConTexto(dir));
				double la = Funciones.getLatitud(dir);
				double lo = Funciones.getLongitud(dir);
				u2.setLatitud(la);
				u2.setLongitud(lo);
				Ruta v  = new Ruta(u, u2, true);
				v.setVisible(true);
				dispose();
				
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