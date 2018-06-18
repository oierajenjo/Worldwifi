package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegistrarUsuario extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	public RegistrarUsuario() {
		setSize (800, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(15, 16, 84, 20);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(15, 52, 84, 20);
		panel_1.add(lblPassword);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 88, 84, 20);
		panel_1.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(15, 124, 69, 20);
		panel_1.add(lblApellido);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(15, 160, 69, 20);
		panel_1.add(lblEmail);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(15, 196, 69, 20);
		panel_1.add(lblCiudad);
		
		JLabel lblTwitter = new JLabel("Twitter:");
		lblTwitter.setBounds(15, 232, 69, 20);
		panel_1.add(lblTwitter);
		
		JLabel lblFacebook = new JLabel("Facebook:");
		lblFacebook.setBounds(15, 268, 84, 20);
		panel_1.add(lblFacebook);
		
		textField = new JTextField();
		textField.setBounds(114, 10, 649, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 49, 649, 26);
		panel_1.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 85, 649, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 121, 649, 26);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 157, 649, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 193, 649, 26);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(114, 229, 649, 26);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(114, 265, 649, 26);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
	}
	

}
