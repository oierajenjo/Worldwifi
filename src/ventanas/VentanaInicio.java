package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import BD.mongo.*;
import common.exceptions.AdminEditException;
import common.exceptions.UserNotFoundException;

import javax.swing.*;
import java.awt.event.*;

/**
*
* @author Oier
*/

@SuppressWarnings("serial")
public class VentanaInicio extends JFrame {

    
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo.png"));
        return retValue;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jbEntrar = new JButton();
        jbSalir = new JButton();
        jtUser = new JTextField();
        jlUsuario = new JLabel();
        jlContraseña = new JLabel();
        jPassword = new JPasswordField();
        jlLogo = new JLabel();
        jbRegistrarse = new JButton();
        jlFondo = new JLabel();

        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("WorldWifi");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        jbEntrar.setBackground(new java.awt.Color(51, 153, 255));
        jbEntrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jbEntrar.setText("Entrar");
        jbEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 120, 40));

        jbSalir.setBackground(new java.awt.Color(51, 153, 255));
        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.setActionCommand("jbSalir");
        jbSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 70, -1));

        jtUser.setBackground(new java.awt.Color(204, 204, 204));
        jtUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtUser.setForeground(new java.awt.Color(255, 255, 255));
        jtUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jtUserActionPerformed(evt);
            }
        });
        getContentPane().add(jtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 200, 50));

        jlUsuario.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuario.setText("Usuario:");
        getContentPane().add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        jlContraseña.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jlContraseña.setText("Contraseña:");
        getContentPane().add(jlContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, -1, -1));

        jPassword.setBackground(new java.awt.Color(204, 204, 204));
        jPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPassword.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 200, 50));

        jlLogo.setIcon(new ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        getContentPane().add(jlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jbRegistrarse.setBackground(new java.awt.Color(51, 153, 255));
        jbRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrarse.setText("Registrarse");
        jbRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(jbRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, 140, -1));

        jlFondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/1389718468_water-drops-on-a-window_ipad.jpg"))); // NOI18N
        getContentPane().add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 770));

        pack();
    }// </editor-fold>                        

    //Getters

    public JPasswordField getjPassword() {
		return jPassword;
	}

	public JTextField getJtUser() {
		return jtUser;
	}
	
	private void jbEntrarActionPerformed(ActionEvent evt) {                                         
        try {
			if (jPassword.getPassword()== BD.mongo.ConectarMongo.getPassword(jtUser.getText())){
				VentanaMapa a = new VentanaMapa();
				a.setVisible(true);
				this.setVisible(false);
			}
		} catch (UserNotFoundException | AdminEditException e) {
			e.printStackTrace();
		}

    }                                        
    
	private void jbRegistrarseActionPerformed(ActionEvent evt) {                                              
        VentanaRegistrar b = new VentanaRegistrar();
        b.setVisible(true);
        this.setVisible(false);
    } 
    
    private void jbSalirActionPerformed(ActionEvent evt) {                                        
        System.exit(0);
    }                                       

    private void jtUserActionPerformed(ActionEvent evt) {                                       
    
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
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JPasswordField jPassword;
    private JButton jbEntrar;
    private JButton jbRegistrarse;
    private JButton jbSalir;
    private JLabel jlContraseña;
    private JLabel jlFondo;
    private JLabel jlLogo;
    private JLabel jlUsuario;
    private JTextField jtUser;

    // End of variables declaration                   
}
