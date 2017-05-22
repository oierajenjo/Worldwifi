package proyecto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

public class VentanaInicio extends JFrame implements ActionListener, Serializable{

	private static final long serialVersionUID = 1L;
	private JButton bJugar;
	private JButton bCrearPregunta;
	private JLabel lPreguntados;
	
	private void posicionaLinea( Container p, Component campo ) {
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout( new FlowLayout(FlowLayout.CENTER) );
		tempPanel.add( campo );
		p.add( tempPanel );
	}
	
	public VentanaInicio () {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(640, 640);
		this.setLocation( new Point(500, 300));
		this.setTitle("Preguntados");
		this.setResizable(false);
		
		bJugar = new JButton("JUGAR");
		bCrearPregunta = new JButton("CREAR NUEVA PREGUNTA");
		lPreguntados = new JLabel("PREGUNTADOS" );
		lPreguntados.setFont(new java.awt.Font("Alien Encounters", 0, 36));
		
		bJugar.setSize(300, 75);
		bCrearPregunta.setSize(300, 75);
		
		Container pOpciones = new JPanel();
		pOpciones.setLayout(new BoxLayout(pOpciones,BoxLayout.X_AXIS));
		posicionaLinea(pOpciones, bJugar);
		posicionaLinea(pOpciones, bCrearPregunta);
		
		Container pTitulo = new JPanel();
		pTitulo.setLayout(new BoxLayout(pTitulo,BoxLayout.X_AXIS));
		posicionaLinea(pTitulo,lPreguntados);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pOpciones, "Center");
		getContentPane().add(pTitulo, "North" );
		
		bCrearPregunta.addActionListener(this);
		bJugar.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();
		if (fuente == bCrearPregunta){
			GestorVentanas.activaVCreador();
			this.setVisible(false);
		}else if (fuente == bJugar){
			GestorVentanas.activaVJugador();
			this.setVisible(false);
		}
	}
}
