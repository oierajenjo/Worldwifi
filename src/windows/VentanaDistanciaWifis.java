package windows;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
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
import org.json.JSONException;

import WiFi.Wifi;
import maps.Distance;
import maps.Funciones;
import maps.FuncionesVariasWifis;

public class VentanaDistanciaWifis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable jTabla;
	private JPanel panel;
	public Ubicacion uAnt;
	public ArrayList<Distance> arrayDistancias = new ArrayList<>();
	public Ubicacion getuAnt() {
		return uAnt;
	}

	public void setuAnt(Ubicacion uAnt) {
		this.uAnt = uAnt;
	}
	public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo.png"));
        return retValue;
    }
	public VentanaDistanciaWifis(Ubicacion u) throws JSONException, IOException{
		setSize (800, 500);
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		arrayDistancias = new ArrayList<>();
		ArrayList<Wifi> wifisCercanas = new ArrayList<Wifi>();
		String[][] datos = new String[10][3];
		System.out.println(u.toString());
		getuAnt();
		if (u != uAnt) {
			wifisCercanas = Inicial.getListaWifis();
			for(Wifi wifi: wifisCercanas) {
				System.out.println(wifi.toString());
				URL url = Funciones.getDistanciaURL(u.getLatitud(), u.getLongitud(), wifi);
				Distance distancia = FuncionesVariasWifis.getDistanciaTotalFromJson(url);
				arrayDistancias.add(distancia);
			}
			Collections.sort(arrayDistancias, Comparator.comparingInt(Distance::getDis_m));

			
			for (int i = 0; i < 10; i++) {
				datos[i][0] = arrayDistancias.get(i).getDestino().toString();
				datos[i][1] = arrayDistancias.get(i).getkmTexto().toString();
				datos[i][2] = arrayDistancias.get(i).getTimeTexto().toString();
			}
			System.out.println(datos);
			uAnt = new Ubicacion();
			setuAnt(u);
			dibujarTabla(datos);
			VentanaSeleccion.setWifis(datos);
			VentanaSeleccion.setAlDistancias(arrayDistancias);
			System.out.println(uAnt.toString());
		}
		else {
			System.out.println(uAnt.toString());
			datos = VentanaSeleccion.getWifis();
			arrayDistancias.clear();
			arrayDistancias = VentanaSeleccion.getAlDistancias();
		}
		
		
		//Se crea una tabla con tres huecos uno destino, otro tiempo y otro distancia
		//arrayDistancias.size();

		
		//		jTabla.setModel(new DefaultTableModel(
		//				new Object [][] {},
		//				new String [] {"Descripcion", "Distancia", "Tiempo"}) {
		//			Class[] types = new Class [] {
		//					String.class, String.class, String.class
		//			};
		//			public Class getColumnClass(int columnIndex) {
		//				return types [columnIndex];
		//			}
		//		});
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
		JButton btnVolver = new JButton("Volver");
		panel_1.add(btnVolver);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				Ubicacion u = new Ubicacion();
				//				u.setDireccion(Inicial.getTuUbicacion().getDireccion());
				//				u.setLatitud(Inicial.getTuUbicacion().getLatitud());
				//				u.setLongitud(Inicial.getTuUbicacion().getLongitud());
				if(u.getDireccion() != null) {
					try {
						Ubicacion u2 = new Ubicacion();
						int i = jTabla.getSelectedRow();
						u2.setDireccion(arrayDistancias.get(i).destino);
						//						u2.setDireccion(Funciones.getDireccionConTexto(dir));
						u2.setLatitud(Funciones.getLatitud(u2.getDireccion()));
						u2.setLongitud(Funciones.getLongitud(u2.getDireccion()));
						Ruta r  = new Ruta(u, u2);
						r.setVisible(true);
						dispose();
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccion v = new VentanaSeleccion(u);
				v.setVisible(true);
				dispose();

			}
		});


	}
	
	@SuppressWarnings("serial")
	private void dibujarTabla(String[][] datosRuta) {
		jTabla = new JTable();
		String[] cols= new String[]{"Destino", "Tiempo", "Distancia"};
		jTabla.setModel(new DefaultTableModel(
				datosRuta,
				cols) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
					String.class, String.class, String.class
			};


			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}
		});
	}
}