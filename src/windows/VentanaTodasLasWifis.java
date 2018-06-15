package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaTodasLasWifis extends JFrame{
	
	public VentanaTodasLasWifis (Ubicacion u){
		setSize (800, 500);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSeleccion v = new VentanaSeleccion(u);
				v.setVisible(true);
				dispose();
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
	}

}
