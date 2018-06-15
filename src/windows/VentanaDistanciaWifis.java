package windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaDistanciaWifis extends JFrame {
	
	public VentanaDistanciaWifis(Ubicacion u){
		setSize (800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		panel_1.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccion v = new VentanaSeleccion(u);
				v.setVisible(true);
				dispose();
				
			}
		});
		
		
	}

}
