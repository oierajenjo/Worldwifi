package windows;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import maps.Funciones;
import usuario.Usuario;

import javax.swing.JPasswordField;

public class InicioSesion extends JFrame{
	private static final long serialVersionUID = 1L;

	public InicioSesion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize (450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		panel.add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuario v = new RegistrarUsuario();
				v.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		panel.add(btnIniciarSesion);
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nick = textField_Usuario.getText();
				char[] pass = passwordField.getPassword();
				String password = "";
				for (char a : pass){
					password += a;
				}
				primeraComprobacionInicioSesion(nick, password);
				if(inicio){
					Inicial v = new Inicial();
					v.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(ventana, "Usuario y/o contrasena incorrecto");
				}
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(15, 40, 86, 20);
		panel_1.add(lblUsername);
		
		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(116, 37, 297, 26);
		panel_1.add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(15, 124, 86, 20);
		panel_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 121, 297, 26);
		panel_1.add(passwordField);
	}
	public HashMap<String, Usuario> grupoUsuarios = new HashMap<>();
	public boolean inicio;
	private JTextField textField_Usuario;
	private JPasswordField passwordField;
	private JFrame ventana = this;
	
	public void inicioSesionConfirmada(Usuario u, String nombre, String apellidos, String email,
			String ciudad, String twitter, String facebook) {
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setEmail(email);
		u.setCiudad(ciudad);
		u.setTwitter(twitter);
		u.setFacebook(facebook);
	}
	
	public void primeraComprobacionInicioSesion(String nick, String password){
		grupoUsuarios = Funciones.leerFichero();
		if(grupoUsuarios.containsKey(nick)){
			if(password.equals(grupoUsuarios.get(nick).getPassword()))
					inicio = true;
		}else{
			inicio = false;
		}
	}

	public static void main(String[] args) {
		InicioSesion v = new InicioSesion();
		v.setVisible(true);
	}
}