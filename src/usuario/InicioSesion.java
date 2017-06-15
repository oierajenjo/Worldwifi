package usuario;

import java.util.ArrayList;

import javafx.scene.chart.PieChart.Data;

@SuppressWarnings("serial")
public class InicioSesion extends UserUsuario {

	public InicioSesion(int id, String user, String password, String nombre, String apellidos, long nacimiento, String email,
			String ciudad, String twitter, String facebook, ArrayList<Amigo> amigos, long fechaCreacion,
			TipoUsuario tipo) {
		super(id, user, password, nombre, apellidos, nacimiento, email, ciudad,  
				twitter, facebook, amigos, tipo, fechaCreacion);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
