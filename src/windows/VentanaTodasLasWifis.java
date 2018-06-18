package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.*;
import WiFi.Wifi;
import maps.java.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class VentanaTodasLasWifis extends JFrame{

	private static final long serialVersionUID = 1L;

	public VentanaTodasLasWifis (Ubicacion u){
		setSize (800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		ponerMarcadores(Inicial.getTuUbicacion(), Inicial.getListaWifis());
		btnVolver.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccion v = new VentanaSeleccion();
				v.setVisible(true);
				dispose();

			}
		});

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);

	}
	public static ShowMaps dibujarMapa() {
		
		
		return null;
		
	}
	public static void ponerMarcadores(Ubicacion tuUbicacion, ArrayList<Wifi> wifis) {
		
		
	}
	public static void unMarcador (Ubicacion ubi) {
		
		
		
	}
}