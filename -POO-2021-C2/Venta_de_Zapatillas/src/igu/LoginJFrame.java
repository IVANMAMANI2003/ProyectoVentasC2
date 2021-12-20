
package igu;

import entidades.Persona;
import implementacion.ImplAdmin;
import implementacion.ImplClientes;
import java.awt.Color;


public class LoginJFrame extends javax.swing.JFrame {


    public LoginJFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        jtxf_usuario = new javax.swing.JTextField();
        Jbt_Login = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        usuario1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/xiaomi_Mi_10T_Pro.png"))); // NOI18N

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("VENTA DE ZAPATILLAS");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 299, 40));

        usuario.setBackground(new java.awt.Color(0, 0, 0));
        usuario.setFont(new java.awt.Font("Perpetua", 3, 24)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuario.setText("Usuario");
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 80, -1));

        jtxf_usuario.setForeground(new java.awt.Color(153, 153, 153));
        jtxf_usuario.setText("Ingrese su nombre de usuario");
        jtxf_usuario.setBorder(null);
        jtxf_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtxf_usuarioMousePressed(evt);
            }
        });
        jtxf_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxf_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jtxf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 310, 20));

        Jbt_Login.setBackground(new java.awt.Color(53, 79, 246));
        Jbt_Login.setFont(new java.awt.Font("Swis721 Blk BT", 1, 18)); // NOI18N
        Jbt_Login.setText("Login");
        Jbt_Login.setBorder(null);
        Jbt_Login.setBorderPainted(false);
        Jbt_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validacionLogueo(evt);
            }
        });
        getContentPane().add(Jbt_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 104, -1));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 310, 10));

        usuario1.setBackground(new java.awt.Color(0, 0, 0));
        usuario1.setFont(new java.awt.Font("Perpetua", 3, 24)); // NOI18N
        usuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuario1.setText("Contraseña");
        getContentPane().add(usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 120, -1));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 310, 10));

        jPasswordField1.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField1.setText("********");
        jPasswordField1.setBorder(null);
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordField1MousePressed(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 310, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\A proyectos 2021 - 2\\Otros recursos\\calzado-air-max-270-KkLcGR.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(67, 229, 136));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void validacionLogueo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validacionLogueo
        
        ImplAdmin ip= new ImplAdmin();
        Persona p= new Persona();
        
        //System.out.println("estoy ´probandoooo"+jtxf_usuario.getText()+"-"+jpsf_password.getText());
        
        p=ip.LoginReportePersonaUnico(jtxf_usuario.getText(), jPasswordField1.getText());
        
        System.out.println("estoy ´probandoooo: "+p.getUsuario()+"-"+p.getPassword());
 
        if(p.isAcceso()){
            
            System.out.println("ingreso al sistema");
            
            
            MenuFrame cmf = new MenuFrame();
            cmf.show();
            
            LoginJFrame lf= new LoginJFrame();
            lf.show(false);
            dispose();
        }
        else{        
          System.out.println("no ingreso al sistema");
        }
    }//GEN-LAST:event_validacionLogueo

    private void jtxf_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxf_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxf_usuarioActionPerformed

    private void jtxf_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxf_usuarioMousePressed
        if(jtxf_usuario.getText().equals("Ingrese su nombre de usuario")){ 
            jtxf_usuario.setText("");
            jtxf_usuario.setForeground(Color.black);
        }
        if(String.valueOf(jPasswordField1.getPassword()).isEmpty()){
            jPasswordField1.setText("********");
            jPasswordField1.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jtxf_usuarioMousePressed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPasswordField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MousePressed
        if(String.valueOf(jPasswordField1.getPassword()).equals("********")){
        jPasswordField1.setText("");
        jPasswordField1.setForeground(Color.black);
        }
        if(jtxf_usuario.getText().isEmpty()){
        jtxf_usuario.setText("Ingrese su nombre de usuario");
        jtxf_usuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jPasswordField1MousePressed

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
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbt_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jtxf_usuario;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel usuario1;
    // End of variables declaration//GEN-END:variables
}
