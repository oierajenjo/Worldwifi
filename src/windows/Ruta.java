package windows;


import javax.swing.BorderFactory;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.json.JSONException;
import org.jsoup.Jsoup;

import maps.java.Route;
import maps.java.StaticMaps;



import java.awt.Dimension;
import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
//import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class Ruta extends JFrame {

	private static final long serialVersionUID = 1L;
//	private BufferedImage mapa;
	private JButton button_Volver;
	private JButton btnMostrarMapa;
	private JPanel panel1;
	private JScrollPane scrollPane1;
	private JTable table_Ruta;
	//	private ArrayList<Indicacion> indicaciones;
	private String direccionLlegada;
	private String direccionSalida;
	private Boolean flagVolver;
	private Route ObjRuta = new Route();
	private JLabel label_Mapa;
	//	private Ubicacion u;
	String[][] resultadoRuta;
	public Ruta(Ubicacion uSalida, Ubicacion uLlegada) { 
		inicializarComponentes();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		direccionLlegada = uLlegada.getDireccion();
		direccionSalida = uSalida.getDireccion();
		try{

			this.calcularRuta();
		}catch(Exception ex){
		}
		//		button_Volver.setEnabled(true);
	}


	public void inicializarComponentes() {
		setSize (800, 500);

		scrollPane1 = new JScrollPane();
		table_Ruta = new JTable();
		panel1 = new JPanel();
		label_Mapa = new JLabel();
		btnMostrarMapa = new JButton();
		button_Volver = new JButton();
		setAlwaysOnTop(true);
		setType(java.awt.Window.Type.UTILITY);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				try {
					formWindowClosing(evt);
				} catch (JSONException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});



		//		table_Ruta.setModel(new DefaultTableModel(
		//				new Object [][] {},
		//				new String [] {"Descripcion", "Distancia", "Tiempo"}) {
		//				Class[] types = new Class [] {
		//					String.class, String.class, String.class
		//			};
		//
		//			
		//			public Class getColumnClass(int columnIndex) {
		//				return types [columnIndex];
		//			}
		//		});
		table_Ruta.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				pulsarTramoRuta(evt);
			}
		});
		scrollPane1.setViewportView(table_Ruta);
		panel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		label_Mapa.setHorizontalAlignment(SwingConstants.CENTER);


		GroupLayout jPanel1Layout = new GroupLayout(panel1);
		panel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(label_Mapa, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(label_Mapa, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
				);



		btnMostrarMapa = new JButton("Mostrar recorrido en mapa");
		btnMostrarMapa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mostrarMapaRecorridoEntero(evt);
			}
		});

		button_Volver.setText("Volver");
		button_Volver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					volverVentanaInicial(evt);
				} catch (JSONException | IOException e) {
					e.printStackTrace();
				}
			}
		});


		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()	
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(scrollPane1).addGroup(layout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE)
														.addComponent(panel1,GroupLayout.PREFERRED_SIZE, 
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap())
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
												.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
								.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()))
						.addComponent(scrollPane1,GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

	}
	private void dibujarMapa(String referencia) throws MalformedURLException, UnsupportedEncodingException {
		StaticMaps ObjStatic = new StaticMaps();
		Image imagenRuta = ObjStatic.getStaticMapRoute(new Dimension(300,200),
				1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap, referencia);
		label_Mapa.setIcon(new ImageIcon(imagenRuta));

	}


	private void dibujarTabla(String[][] datosRuta) {
		String[] columnNames = {"Descripcion", "Distancia", "Tiempo"};
		TableModel tableModel=new DefaultTableModel(datosRuta, columnNames);
		this.table_Ruta.setModel(tableModel);
		this.table_Ruta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table_Ruta.setRowSelectionInterval(0, 0);
	}



	private void formWindowClosing(WindowEvent evt) throws JSONException, IOException {
		this.cerrarVentana();
	}

	private void cerrarVentana() throws JSONException, IOException{
		if(flagVolver==true){
			this.volver();
		}else{
			this.setVisible(false);
		}
	}

	private void volver() throws JSONException, IOException{
		this.setVisible(false);
		Inicial v =new Inicial();
		v.setVisible(true);
		dispose();
	}




	private void calcularRuta() throws MalformedURLException, UnsupportedEncodingException {
		//		indicaciones = Funciones.getIndicaciones(direccionSalida, direccionLlegada);

		resultadoRuta = ObjRuta.getRoute(direccionSalida, direccionLlegada, null, true, Route.mode.walking, Route.avoids.nothing);
		String[][] datosRuta=new String[resultadoRuta.length][3];
		for(int i = 0; i< datosRuta.length;i++){
			datosRuta[i][0]= resultadoRuta[i][0];
			datosRuta[i][1]= resultadoRuta[i][2];
			datosRuta[i][2]= Jsoup.parse(resultadoRuta[i][2]).text();
		}
		System.out.println(datosRuta);
		this.dibujarTabla(datosRuta);	
		this.dibujarMapa(ObjRuta.getPolilines().get(0));

	}

	private void pulsarTramoRuta(MouseEvent evt) {
		try {
			this.dibujarMapa(ObjRuta.getPolilines().get(this.table_Ruta.getSelectedRow()));
		} catch (Exception ex) {
		}
	}

	private void mostrarMapaRecorridoEntero(ActionEvent evt) {
		try {
			this.dibujarMapa(ObjRuta.getGeneralPolyline());
		} catch (Exception ex) {
		}
	}
	private void volverVentanaInicial(ActionEvent evt) throws JSONException, IOException {
		this.volver();
	}



}
