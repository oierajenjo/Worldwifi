package ventanas;

import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.*;

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

        jbEntrar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jtUser = new javax.swing.JTextField();
        jlUsuario = new javax.swing.JLabel();
        jlContraseña = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jlLogo = new javax.swing.JLabel();
        jbRegistrarse = new javax.swing.JButton();
        jlFondo = new javax.swing.JLabel();

        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 120, 40));

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
        getContentPane().add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 70, -1));

        jtUser.setBackground(new java.awt.Color(204, 204, 204));
        jtUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtUser.setForeground(new java.awt.Color(255, 255, 255));
        jtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        getContentPane().add(jlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jbRegistrarse.setBackground(new java.awt.Color(51, 153, 255));
        jbRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrarse.setText("Registrarse");
        jbRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(jbRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, 140, -1));

        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1389718468_water-drops-on-a-window_ipad.jpg"))); // NOI18N
        getContentPane().add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 770));

        pack();
    }// </editor-fold>                        

    private void jbEntrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        VentanaMapa a = new VentanaMapa();
        a.setVisible(true);
        this.setVisible(false);
    }                                        

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }                                       

    private void jtUserActionPerformed(java.awt.event.ActionEvent evt) {                                       
    
    }                                      

    private void jbRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {                                              
        VentanaRegistrar b = new VentanaRegistrar();
        b.setVisible(true);
        this.setVisible(false);
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton jbEntrar;
    private javax.swing.JButton jbRegistrarse;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlContraseña;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTextField jtUser;

    // End of variables declaration                   
}
