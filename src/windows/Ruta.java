package windows;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jsoup.Jsoup;

import maps.java.Route;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class Ruta extends JFrame {
	private BufferedImage streetView;
	private BufferedImage mapa;
	private JPanel panel;
	private JButton button_Volver;
    private JButton btnPlus;
    private JButton btnPlus2;
    private JButton btnMostrarMapa;
    private JLabel label_ImagenStreet;
    private JLabel label_Mapa;
    private JPanel panel1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable table_Ruta;
    private String[][] resultadoRuta;
    private String direccionLlegada;
    private String direccionSalida;
    private Route.mode modoRuta=Route.mode.driving;
    private double fov=0.0;
    private Boolean flagVolver;
    private Route ObjRuta = new Route();
	private String[][] datosRuta;
	
    
	public Ruta() {
		setSize (800, 500);
		
		panel = new JPanel();
		GroupLayout jPanel1Layout = new GroupLayout(panel);
        panel.setLayout(jPanel1Layout);

        btnPlus = new JButton("+");
        btnPlus2 = new JButton("+");
        btnMostrarMapa = new JButton("Mostrar recorrido en mapa");

        
        
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup().addContainerGap()	
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        		.addComponent(scrollPane1).addGroup(layout.createSequentialGroup()
        		.addGap(0, 0, Short.MAX_VALUE)
        		.addComponent(btnPlus2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        		.addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        		.addComponent(btnPlus).addGap(26, 26, 26).addComponent(panel,GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        		.addContainerGap())
        		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        		.addComponent(btnMostrarMapa).addGap(111, 111, 111))))
        		);
        
        layout.setVerticalGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(btnMostrarMapa).addComponent(button_Volver))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(btnPlus)
            .addGap(106, 106, 106))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(btnPlus2)
            .addGap(108, 108, 108)))
            .addComponent(scrollPane1,GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        	);
				
	}
	private void dibujarMapa(String string) {
		// TODO Auto-generated method stub
		
	}

	private void dibujarStreetView(Double valueOf, Double valueOf2) {
		// TODO Auto-generated method stub
		
	}

	private void dibujarTabla(String[][] datosRuta) {
		String[] columnas = new String[3];
		String[] columnNames = {"Duración indicación", "Distancia a recorrer en tramo", "Indicaciones de tramo"};
		TableModel tableModel=new DefaultTableModel(datosRuta, columnNames);
		this.table_Ruta.setModel(tableModel);
		
	}
	
	

	private void calcularRuta() throws MalformedURLException, UnsupportedEncodingException {
		resultadoRuta=ObjRuta.getRoute(direccionSalida, direccionLlegada, null, true, modoRuta, Route.avoids.nothing);
		datosRuta=new String[resultadoRuta.length][3];
		for(int i=0;i<datosRuta.length;i++){
			datosRuta[i][0]=resultadoRuta[i][0];
			datosRuta[i][1]=resultadoRuta[i][1];
			datosRuta[i][2]=Jsoup.parse(resultadoRuta[i][2]).text();
		}
		this.dibujarTabla(datosRuta);
		this.dibujarStreetView(Double.valueOf(resultadoRuta[0][3]), Double.valueOf(resultadoRuta[0][4]));
		this.dibujarMapa(ObjRuta.getPolilines().get(0));
		this.table_Ruta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table_Ruta.setRowSelectionInterval(0, 0);	
	}

}
