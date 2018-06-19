package windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Comun.DocumentReader;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import maps.Funciones;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.JButton;

public class VentanaTodasLasWifis extends JFrame{

	//https://datos.madrid.es/egob/new/detalle/auxiliar/mapa.jsp?geoUrl=https%3A%2F%2Fdatos.madrid.es%2Fegob%2Fcatalogo%2F216619-0-wifi-municipal.geo?millis=1529263424677
	
	private static final long serialVersionUID = 1L;
	public Ubicacion uSalida;
	
	public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo.png"));
        return retValue;
    }
	public VentanaTodasLasWifis (Ubicacion u){
		setSize (800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(getIconImage());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		uSalida = new Ubicacion();
		uSalida = u;
		JButton btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
					VentanaSeleccion v = new VentanaSeleccion(uSalida);
					v.setVisible(true);
					dispose();

			}
		});

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		JButton btnBrowser = new JButton("Buscar");
		panel_1.add(btnBrowser);
		btnBrowser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NodeList nList = DocumentReader.getDoc("mapas.xml").getElementsByTagName(Inicial.getCiudad());
				Node nNode = nList.item(0);
				Element eElement = (Element) nNode;
				String direccionMapa = eElement.getElementsByTagName("url").item(0).getTextContent();
				try {
					Desktop.getDesktop().browse(new URI(direccionMapa));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
		});

	}
}