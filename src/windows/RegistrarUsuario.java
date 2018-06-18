package windows;

import javax.swing.JFrame;
import Comun.FicheroErrorException;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


import usuario.Usuario;

import javax.swing.JPasswordField;

public class RegistrarUsuario extends JFrame{
	private JTextField textField_Nick;
	private JPasswordField passwordField;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_Email;
	private JTextField textField_Ciudad;
	private JTextField textField_Twitter;
	private JTextField textField_Facebook;
	public static HashMap<String, Usuario> grupoUsuarios = new HashMap<>();

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

		textField_Facebook = new JTextField();
		textField_Facebook.setBounds(114, 265, 649, 26);
		panel_1.add(textField_Facebook);
		textField_Facebook.setColumns(10);

	}

	public ArrayList<Usuario> leerFichero(){
		try{
			FileReader fr = new FileReader("Usuarios.txt");
			BufferedReader bf = new BufferedReader(fr);
			String line = null;
			while ((line = bf.readLine()) != null){
				String[] parts = line.split("/_\\;");
				char[] pass = parts[1].toCharArray();
				int numero = Integer.parseInt(parts[2]);
				Usuario u = new Usuario (parts[0], pass, parts[2],parts[3],parts[4],parts[5],parts[6], parts[7]);
				grupoUsuarios.put(u.getUser(), u);
			}
			bf.close();
			fr.close();

		}catch (IOException FileNotFound){
			throw new FicheroErrorException("Fichero no encontrado", FileNotFound);
		}
		return null;

	}
	
	public static void guardarFichero(){
		try {
			FileWriter fw = new FileWriter("Usuarios.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			Iterator<Usuario> it = ((List<Usuario>) grupoUsuarios).iterator();
			
			while(it.hasNext()){
				Usuario u = it.next();
				bw.write(u.toString());
			}
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
