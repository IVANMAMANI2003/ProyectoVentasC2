/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igu.productos;

import entidades.Producto;
import implementacion.ImplProducto;
import interfacesDao.InterProductoDao;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class ProductosJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ProductosJDialog
     */
     DefaultTableModel modelo;
    ImplProducto productoDao= new ImplProducto(); 
    
    public ProductosJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        ReporteData();
        setTitle("Gestion de Productos");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelProducto = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanelIngresoDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        P_nombre = new javax.swing.JTextField();
        P_marca = new javax.swing.JTextField();
        P_color = new javax.swing.JTextField();
        P_stock = new javax.swing.JTextField();
        P_precio = new javax.swing.JTextField();
        P_id = new javax.swing.JTextField();
        P_talla = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanelButtons = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelProducto.setBackground(new java.awt.Color(0, 204, 153));
        jPanelProducto.setFocusTraversalPolicyProvider(true);
        jPanelProducto.setFocusable(false);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(51, 255, 204));
        jTextField2.setFont(new java.awt.Font("OCR-A BT", 3, 24)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Registro de Productos");
        jTextField2.setFocusTraversalPolicyProvider(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanelIngresoDatos.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 2, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 2, 14)); // NOI18N
        jLabel2.setText("Marca");

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 2, 14)); // NOI18N
        jLabel3.setText("Color");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 2, 14)); // NOI18N
        jLabel4.setText("Stock");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 2, 14)); // NOI18N
        jLabel5.setText("Precio");

        P_id.setBackground(new java.awt.Color(204, 255, 204));
        P_id.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 2, 14)); // NOI18N
        jLabel9.setText("Talla");

        javax.swing.GroupLayout jPanelIngresoDatosLayout = new javax.swing.GroupLayout(jPanelIngresoDatos);
        jPanelIngresoDatos.setLayout(jPanelIngresoDatosLayout);
        jPanelIngresoDatosLayout.setHorizontalGroup(
            jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresoDatosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelIngresoDatosLayout.createSequentialGroup()
                        .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(P_talla)
                            .addComponent(P_marca)
                            .addComponent(P_color)
                            .addComponent(P_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(P_precio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(P_stock, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(P_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanelIngresoDatosLayout.setVerticalGroup(
            jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresoDatosLayout.createSequentialGroup()
                .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelIngresoDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(P_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(P_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(P_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(P_talla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(P_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelIngresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(P_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanelButtons.setBackground(new java.awt.Color(204, 255, 153));

        jButtonGuardar.setIcon(new javax.swing.ImageIcon("D:\\A proyectos 2021 - 2\\Otros recursos\\Iconos\\guardar_mediano.png")); // NOI18N
        jButtonGuardar.setToolTipText("");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonActualizar.setIcon(new javax.swing.ImageIcon("D:\\A proyectos 2021 - 2\\Otros recursos\\Iconos\\actualizar.png")); // NOI18N
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonEliminar.setIcon(new javax.swing.ImageIcon("D:\\A proyectos 2021 - 2\\Otros recursos\\Iconos\\eliminar mediano.png")); // NOI18N
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Guardar");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Actualizar");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Eliminar");

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminar)
                .addContainerGap())
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(67, 67, 67)
                .addComponent(jLabel8)
                .addGap(41, 41, 41))
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelIngresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelIngresoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTableProducto.setBackground(new java.awt.Color(204, 255, 255));
        jTableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProducto);

        javax.swing.GroupLayout jPanelProductoLayout = new javax.swing.GroupLayout(jPanelProducto);
        jPanelProducto.setLayout(jPanelProductoLayout);
        jPanelProductoLayout.setHorizontalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTextField2)
        );
        jPanelProductoLayout.setVerticalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        Producto pr= new Producto();
        
        pr.setNombre(P_nombre.getText());
        pr.setMarca(P_marca.getText());
        pr.setColor(P_color.getText());
        pr.setTalla(P_talla.getText());
        pr.setStock(Integer.parseInt( P_stock.getText() ) );
        pr.setPrecio(Double.parseDouble(P_precio.getText()));

        if(P_id.getText().equals("") || !P_nombre.getText().equals("") || !P_marca.getText().equals("") || !P_color.getText().equals("") || !P_talla.getText().equals("") ||  !P_stock.getText().equals("") || !P_precio.getText().equals("")  ){
            
            
            productoDao.registrarProd(pr);
            P_id.setText("");
            P_nombre.setText("");
            P_marca.setText("");
            P_color.setText("");
            P_talla.setText("");
            P_stock.setText("");
            P_precio.setText("");
            
            JOptionPane.showMessageDialog(
                null,
                "Se registro conExito",
                "Registro",
                JOptionPane.INFORMATION_MESSAGE);
            LimpiarTablaProducto();
            ReporteData();
        }
        else{
            JOptionPane.showMessageDialog(
                null,
                "No se registro",
                "Error/Advertencia",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        String nombre= P_nombre.getText(); 
        
        productoDao.eliminarProducto(nombre);
        
        //if(productoDao.eliminarProducto(id)== -1){
           //modelo.getDataVector().removeAllElements();
            //modelo.removeRow(jTableProducto.getSelectedRow());
        
            //jTableProducto.updateUI();
            LimpiarTablaProducto();
            ReporteDatanew();
             
        //}
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        Producto prod= new Producto(); 
        
        prod.setNombre(P_nombre.getText());
        prod.setMarca(P_marca.getText());
        prod.setColor(P_color.getText());
        prod.setTalla(P_talla.getText());
        prod.setStock(Integer.parseInt(P_stock.getText()));
        prod.setPrecio(Double.parseDouble( P_precio.getText()));
        
        productoDao.ActualizarProd(prod);
        LimpiarTablaProducto();
        ReporteData();
            
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jTableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductoMouseClicked
        int row=jTableProducto.getSelectedRow();
        
        String nombre = jTableProducto.getValueAt(row, 1).toString();
        String marca  = jTableProducto.getValueAt(row, 2).toString();
        String color  = jTableProducto.getValueAt(row, 3).toString();
        String stock  = jTableProducto.getValueAt(row, 4).toString();
        String precio  = jTableProducto.getValueAt(row, 5).toString();
        
        System.out.println("Holasss"+nombre+marca+color+stock+precio);
        
        P_nombre.setText(nombre);
        P_marca.setText(marca);
        P_color.setText(color);
        P_stock.setText(stock);
        P_precio.setText(precio);
        
    }//GEN-LAST:event_jTableProductoMouseClicked
public void ReporteData(){                  

            modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Marca");
            modelo.addColumn("Color");
            modelo.addColumn("Talla");
            modelo.addColumn("Stock");
            modelo.addColumn("Precio");
            /*
            productoDao=new ImplProducto();
            System.out.println("ndd"+ productoDao.reporteProd().size());
*/
                for (Producto pr : productoDao.reporteProd()) {
                    Object[] fila = new Object[7];
                    fila[0] = pr.getId();
                    fila[1] = pr.getNombre();
                    fila[2] = pr.getMarca();
                    fila[3] = pr.getColor();
                    fila[4] = pr.getTalla();
                    fila[5] = pr.getStock();
                    fila[6] = pr.getPrecio();

                    modelo.addRow(fila);
                }

            //jTablePersonas = new JTable();
            jTableProducto.setModel(modelo); 
        
           
    }
public void ReporteDatanew(){                  

            modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Marca");
            modelo.addColumn("Color");
            modelo.addColumn("Talla");
            modelo.addColumn("Stock");
            modelo.addColumn("Precio");
            /*
            productoDao=new ImplProducto();
            System.out.println("ndd"+ productoDao.reporteProd().size());
*/
                for (Producto pr : productoDao.reporteProduc()) {
                    Object[] fila = new Object[6];
                    fila[0] = pr.getId();
                    fila[1] = pr.getNombre();
                    fila[2] = pr.getMarca();
                    fila[3] = pr.getColor();
                    fila[4] = pr.getTalla();
                    fila[5] = pr.getStock();
                    fila[6] = pr.getPrecio();

                    modelo.addRow(fila);
                }

            //jTablePersonas = new JTable();
            jTableProducto.setModel(modelo);
           
    }
    public void LimpiarTablaProducto() {
            for (int p = 0; p < modelo.getRowCount(); p++) {
                modelo.removeRow(p);
                p = p - 1;
            }
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
            java.util.logging.Logger.getLogger(ProductosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductosJDialog dialog = new ProductosJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField P_color;
    private javax.swing.JTextField P_id;
    private javax.swing.JTextField P_marca;
    private javax.swing.JTextField P_nombre;
    private javax.swing.JTextField P_precio;
    private javax.swing.JTextField P_stock;
    private javax.swing.JTextField P_talla;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelIngresoDatos;
    private javax.swing.JPanel jPanelProducto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProducto;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
