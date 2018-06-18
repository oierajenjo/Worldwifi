package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.swing.JButton;

public class VentanaSeleccion extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaSeleccion(Ubicacion u){
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
				System.out.println(u.toString());
				if(u.getDireccion() != null) {
					try {
						VentanaDistanciaWifis v = new VentanaDistanciaWifis(u);
						v.setVisible(true);
						dispose();
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (JSONException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
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
