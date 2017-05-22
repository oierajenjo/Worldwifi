package proyecto_anopasado;

import javax.swing.*;

import Creador.*;
import partida.*;

public class GestorVentanas extends JFrame {

	private static final long serialVersionUID = 2156236265715508763L;
	private static VentanaJuego vJuego;
	private static VentanaInicio vInicio;
	private static VentanaPregunta vPregunta;
	private static VentanaJugadores vJugador;
	private static VentanaCreadorPreguntas vCreador;
	private static Partida partida;
	private static Preguntas preguntas;
	// Crear Getters para inicializar cada parte

	public static VentanaJuego getVJuego() {
		return vJuego;
	}
	public static VentanaInicio getVInicio() {
		return vInicio;
	}
	public static VentanaPregunta getVPregunta() {
		return vPregunta;
	}
	public static VentanaJugadores getVJugador() {
		return vJugador;
	}
	public static VentanaCreadorPreguntas getVCreador() {
		return vCreador;
	}

	public static void init(){
		partida = new Partida();
		preguntas = new  Preguntas();
		vJugador = new VentanaJugadores();
		vJuego = new VentanaJuego(partida);
		vPregunta = new VentanaPregunta( partida, vJuego);
		vCreador = new VentanaCreadorPreguntas();
		vInicio = new VentanaInicio();
	}
	public static void activaVInicio() {
		vInicio = new VentanaInicio();
		vInicio.setVisible(true);
//		vJuego.setVisible(false);
//		vPregunta.setVisible(false);
//		vJugador.setVisible(false);
//		vCreador.setVisible(false);
	}	
	public static void activaVJuego() {
		vJuego = new VentanaJuego(partida);
//		vInicio.setVisible( false );
		vJuego.setVisible(true);
//		vPregunta.setVisible(false);
//		vJugador.setVisible(false);
//		vCreador.setVisible(false);
	}
	public static void activaVPregunta() {
		vPregunta = new VentanaPregunta( partida, vJuego);
//		vInicio.setVisible( false );
//		vJuego.setVisible(false);
		vPregunta.setVisible(true);
//		vJugador.setVisible(false);
//		vCreador.setVisible(false);
	}
	public static void activaVJugador() {
		vJugador = new VentanaJugadores();
//		vInicio.setVisible( false );
//		vJuego.setVisible(false);
//		vPregunta.setVisible(false);
		vJugador.setVisible(true);
//		vCreador.setVisible(false);
	}
	public static void activaVCreador() {
		vCreador = new VentanaCreadorPreguntas();
//		vInicio.setVisible( false );
//		vJuego.setVisible(false);
//		vPregunta.setVisible(false);
//		vJugador.setVisible(false);
		vCreador.setVisible(true);
	}
	public static void main(String[] args) {	
		init();
		activaVInicio();
		try {
			preguntas.readPreguntasFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			preguntas.readSystemFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
