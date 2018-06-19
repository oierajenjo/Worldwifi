package windows;

import javax.swing.JFrame;
import maps.Funciones;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


import usuario.Usuario;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class RegistrarUsuario extends JFrame{
	private JTextField textField_Nick;
	private JPasswordField passwordField;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_Email;
	private JTextField textField_Ciudad;
	private JTextField textField_Twitter;
//	private JTextField textField_Facebook;
	public HashMap<String, Usuario> grupoUsuarios = new HashMap<>();
	public ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo.png"));
        return retValue;
    }
	public RegistrarUsuario() {
		setSize (800, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(getIconImage());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InicioSesion v = new InicioSesion();
				v.setVisible(true);
				dispose();
				
			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user =  textField_Nick.getText();
				char[] pass = passwordField.getPassword();
				String nombre = textField_Nombre.getText();
				String apellidos = textField_Apellido.getText();
				String email = textField_Email.getText();
				String ciudad = textField_Ciudad.getText();
				String twitter = textField_Twitter.getText();
//				String facebook = textField_Facebook.getText();
				
				String password = "";
				for (char a : pass){
					password += a;
				}
				Usuario u = new Usuario(user, password, nombre, apellidos, email, ciudad, twitter);
				grupoUsuarios.put(user, u);
				usuarios.add(u);
				Funciones.guardarFichero(usuarios);
				InicioSesion v = new InicioSesion();
				v.setVisible(true);
				dispose();
			}
		});

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

//		JLabel lblFacebook = new JLabel("Facebook:");
//		lblFacebook.setBounds(15, 268, 84, 20);
//		panel_1.add(lblFacebook);

		textField_Nick = new JTextField();
		textField_Nick.setBounds(114, 10, 649, 26);
		panel_1.add(textField_Nick);
		textField_Nick.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(114, 49, 649, 26);
		panel_1.add(passwordField);

		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(114, 85, 649, 26);
		panel_1.add(textField_Nombre);
		textField_Nombre.setColumns(10);

		textField_Apellido = new JTextField();
		textField_Apellido.setBounds(114, 121, 649, 26);
		panel_1.add(textField_Apellido);
		textField_Apellido.setColumns(10);

		textField_Email = new JTextField();
		textField_Email.setBounds(114, 157, 649, 26);
		panel_1.add(textField_Email);
		textField_Email.setColumns(10);

		textField_Ciudad = new JTextField();
		textField_Ciudad.setBounds(114, 193, 649, 26);
		panel_1.add(textField_Ciudad);
		textField_Ciudad.setColumns(10);

		textField_Twitter = new JTextField();
		textField_Twitter.setBounds(114, 229, 649, 26);
		panel_1.add(textField_Twitter);
		textField_Twitter.setColumns(10);

//		textField_Facebook = new JTextField();
//		textField_Facebook.setBounds(114, 265, 649, 26);
//		panel_1.add(textField_Facebook);
//		textField_Facebook.setColumns(10);

	}

		


}