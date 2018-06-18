package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.swing.JButton;

public class VentanaSeleccion extends JFrame {
	VentanaDistanciaWifis v;
	private static final long serialVersionUID = 1L;

	public VentanaSeleccion(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize (450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnDistanciaATodas = new JButton("Distancia a todas las Wifis");
		btnDistanciaATodas.setBounds(106, 68, 225, 29);
		panel.add(btnDistanciaATodas);
		btnDistanciaATodas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					v = new VentanaDistanciaWifis();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				v.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnTodasLasWifis = new JButton("Todas las Wifis en un Mapa");
		btnTodasLasWifis.setBounds(106, 141, 225, 29);
		panel.add(btnTodasLasWifis);
		btnTodasLasWifis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTodasLasWifis v = new VentanaTodasLasWifis(Inicial.getTuUbicacion());
				v.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(298, 199, 115, 29);
		panel.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Inicial v = new Inicial();
				v.setVisible(true);
				dispose();
				
			}
		});
		
		
	}

}
