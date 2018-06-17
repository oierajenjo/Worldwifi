

package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;


import javax.swing.WindowConstants;

import com.sun.org.apache.xpath.internal.functions.FuncId;

import BD.mySQL.MySQLUtils;
import maps.*;
/**
 *
 * @author Oier
 */
@SuppressWarnings("serial")
public class VentanaMapa extends javax.swing.JFrame {

    /** Creates new form VentanaMapa */
    public VentanaMapa() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo.png"));
        return retValue;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jbSalir = new javax.swing.JButton();
        jlFondo = new javax.swing.JLabel();
        jtLugar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton("Buscar");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("WorldWifi");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(610, 770));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(610, 770));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbSalir.setBackground(new java.awt.Color(51, 153, 255));
        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.setActionCommand("jbSalir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 120, 40));


        
        jbBuscar.setBackground(new java.awt.Color(51, 153, 255));
        jbBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbBuscar.setText("Buscar");
        jbBuscar.setActionCommand("jbBuscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jbBuscarActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
        });
        getContentPane().add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 120, 40));
        
        jtLugar.setBackground(new java.awt.Color(204, 204, 204));
        jtLugar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtLugar.setForeground(new java.awt.Color(255, 255, 255));
        jtLugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jtLugarActionPerformed(evt);
                
            }
        });
        getContentPane().add(jtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 200, 40));
        
        
        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1389718468_water-drops-on-a-window_ipad.jpg"))); // NOI18N
        getContentPane().add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 770));
        pack();
    }// </editor-fold>                        

    protected void jbBuscarActionPerformed(ActionEvent evt) throws SQLException{
    	if (jtLugar.getText() != null){
        	String barrio = "";
			try {
				barrio = Funciones.getBarrio(Funciones.getLatitud(jtLugar.getText()), Funciones.getLongitud(jtLugar.getText()));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
            MySQLUtils.dwhLog(barrio);
        }
	}

	private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }                                       

	private void jtLugarActionPerformed(ActionEvent evt) {
		
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        VentanaMapa vm = new VentanaMapa();
//        if(vm.jbBuscar.)
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMapa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JTextField jtLugar;
    // End of variables declaration                   

}
