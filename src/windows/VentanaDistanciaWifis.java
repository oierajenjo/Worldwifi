package windows;

import java.awt.BorderLayout;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.json.JSONException;

import WiFi.Wifi;
import maps.Distance;
import maps.Funciones;
import maps.FuncionesVariasWifis;

public class VentanaDistanciaWifis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable jTabla;
	private JPanel panel;
	
	
	public VentanaDistanciaWifis(Ubicacion u) throws JSONException, IOException{
		setSize (800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		ArrayList<Wifi> wifisCercanas = new ArrayList<Wifi>();
		wifisCercanas = Inicial.getListaWifis();
		ArrayList<Distance> arrayDistancias = new ArrayList<>();
		for(Wifi wifi: wifisCercanas) {
			System.out.println(wifi.toString());
			URL url = Funciones.getDistanciaURL(u.getLatitud(), u.getLongitud(), wifi);
			Distance distancia = FuncionesVariasWifis.getDistanciaTotalFromJson(url);
			arrayDistancias.add(distancia);
		}
		Collections.sort(arrayDistancias, Comparator.comparingInt(Distance::getDis_m));
		
		String[][] datos = new String[10][3];
		for (int i = 0; i < 10; i++) {
			datos[i][0] = arrayDistancias.get(i).getDestino().toString();
			datos[i][1] = arrayDistancias.get(i).getkmTexto().toString();
			datos[i][2] = arrayDistancias.get(i).getTimeTexto().toString();
		}
		System.out.println(datos);
		//Se crea una tabla con tres huecos uno destino, otro tiempo y otro distancia
		//arrayDistancias.size();
		
		dibujarTabla(datos);
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
		
		jTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTabla.setRowSelectionInterval(0, 0);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ubicacion u2 = new Ubicacion();
				int i = jTabla.getSelectedRow();
				u2.setDireccion(arrayDistancias.get(i).destino);
//				u2.setDireccion(Funciones.getDireccionConTexto(dir));
				u2.setLatitud(Funciones.getLatitud(u2.getDireccion()));
				u2.setLongitud(Funciones.getLongitud(u2.getDireccion()));
				Ruta r  = new Ruta(u, u2, true);
				r.setVisible(true);
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
	private void dibujarTabla(String[][] datosRuta) {
		jTabla = new JTable();
		String[] cols= new String[]{"Destino", "Tiempo", "Distancia"};
		TableModel tableModel = new DefaultTableModel(datosRuta, cols);
		this.jTabla.setModel(tableModel);

	}
	
}