package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Inicial extends JFrame{
	private JTextField textField_DirUsuario;
	private JTextField textField_DirValidacion;
	public Inicial() {
		
		setSize (600, 500);
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
		
		JButton btnValidarUbicacin = new JButton("Validar Ubicaci\u00F3n");
		btnValidarUbicacin.setBounds(128, 199, 155, 29);
		panel.add(btnValidarUbicacin);
	}
}
