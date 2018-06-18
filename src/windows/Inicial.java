package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import BD.neo4j.Neo4j;
import WiFi.Wifi;
import maps.Funciones;

import javax.swing.JButton;

public class Inicial extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField textField_DirUsuario;
	private JTextField textField_DirValidacion;
	private static String ciudad;
	private static ArrayList<Wifi> listaWifis;
	private static Ubicacion tuUbicacion;

	public Inicial() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize (450, 300);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblInserteLaUbicacin = new JLabel("Inserte la ubicaci\u00F3n en la que se encuentre usted");
		lblInserteLaUbicacin.setBounds(15, 16, 344, 20);
		panel.add(lblInserteLaUbicacin);

		textField_DirUsuario = new JTextField();
		textField_DirUsuario.setBounds(15, 52, 385, 26);
		panel.add(textField_DirUsuario);
		textField_DirUsuario.setColumns(10);


		JLabel lblDireccinDeValidacin = new JLabel("Direcci\u00F3n de validaci\u00F3n");
		lblDireccinDeValidacin.setBounds(15, 94, 344, 20);
		panel.add(lblDireccinDeValidacin);

		textField_DirValidacion = new JTextField();
		textField_DirValidacion.setBounds(15, 130, 385, 26);
		panel.add(textField_DirValidacion);
		textField_DirValidacion.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(298, 199, 115, 29);
		panel.add(btnAceptar);
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ubicacion u = new Ubicacion();
				u.setDireccion(textField_DirValidacion.getText());
				double la;
				double lo;

				String dir = textField_DirUsuario.getText();
				la = Funciones.getLatitud(dir);
				lo = Funciones.getLongitud(dir);
				u.setLatitud(la);
				u.setLongitud(lo);
				VentanaSeleccion v = new VentanaSeleccion(u);
				v.setVisible(true);
				dispose();


			}
		});

		JButton btnValidarUbicacion = new JButton("Validar Ubicaci\u00F3n");
		btnValidarUbicacion.setBounds(128, 199, 155, 29);
		panel.add(btnValidarUbicacion);
		btnValidarUbicacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dir = textField_DirUsuario.getText();
				textField_DirValidacion.setText(Funciones.getDireccionConTexto(dir));
				//				tuUbicacion.setDireccion(Funciones.getDireccionConTexto(dir));
				//				tuUbicacion.setLatitud(Funciones.getLatitud(Funciones.getDireccionConTexto(dir)));
				//				tuUbicacion.setLongitud(Funciones.getLongitud(Funciones.getDireccionConTexto(dir)));
				System.out.println(Funciones.getDireccionConTexto(dir));
				try {
					setCiudad(Funciones.getCiudad(dir));
					System.out.println(ciudad);
					TextField cargando = new TextField("Cargando...");
					add(cargando);
					cargando.setVisible(true);
					Neo4j neo = new Neo4j();
					setListaWifis(neo.conseguirWifis(ciudad));
					cargando.setText("");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}

				//				new Thread() { // Crea un hilo
				//					@Override
				//					public void run() {					
				//					}
				//				};
				//				System.out.println(listaWifis);

				if (!textField_DirValidacion.getText().isEmpty()) {
					btnAceptar.setEnabled(true);
				}
			}
		});
	}


	public static ArrayList<Wifi> getListaWifis() {
		return listaWifis;
	}

	public void setListaWifis(ArrayList<Wifi> listaWifis) {
		Inicial.listaWifis = listaWifis;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		Inicial.ciudad = ciudad;
	}

	public static Ubicacion getTuUbicacion() {
		return tuUbicacion;
	}

	public static void setTuUbicacion(Ubicacion tuUbicacion) {
		Inicial.tuUbicacion = tuUbicacion;
	}

	public static void main(String[] args) {
		Inicial i = new Inicial();
		i.setVisible(true);
	}
}