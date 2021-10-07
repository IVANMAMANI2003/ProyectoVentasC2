
package examen_appcrud;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;


import java.util.logging.Level;
import java.util.logging.Logger;


public class MetodosCrud extends JFrame  {
    DatosPersona DatosP= new DatosPersona();
    MetodosSistema metodos = new MetodosSistema();
    IDPersona IdP=new IDPersona();

    public MetodosCrud() {
 
        JMenuBar menuBar=new JMenuBar();
        
        JMenu menuFile=new JMenu();
        JMenu menuMantenimiento=new JMenu();
        JMenu menuReportes=new JMenu();
        
        JMenuItem menuFile_Exit = new JMenuItem();
        JMenuItem menuFile_NewFile = new JMenuItem();
        JMenuItem menuMantenimiento_Ingresar = new JMenuItem();
        JMenuItem menuMantenimiento_Editar = new JMenuItem();
        JMenuItem menuMantenimiento_Eliminar = new JMenuItem();
        
        JMenuItem menuReportes_General = new JMenuItem();
        JMenuItem menuReportes_Detallado = new JMenuItem();
        
        menuFile.setText("File");
        menuFile_NewFile.setText("New File");
        menuFile_Exit.setText("Exit");
        
        menuMantenimiento.setText("Edition");
        menuMantenimiento_Ingresar.setText("Registrar");
        menuMantenimiento_Editar.setText("Editar");
        menuMantenimiento_Eliminar.setText("Eliminar");
        
        menuReportes.setText("Reportes");
        menuReportes_General.setText("Global");
        menuReportes_Detallado.setText("Detalles");
        
       
        
        menuFile.add(menuFile_Exit);
        menuFile.add(menuFile_NewFile);
        menuMantenimiento.add(menuMantenimiento_Ingresar);
        menuMantenimiento.add(menuMantenimiento_Editar);
        menuMantenimiento.add(menuMantenimiento_Eliminar);
        menuReportes.add(menuReportes_General);
        menuReportes.add(menuReportes_Detallado);
        
        menuBar.add(menuFile);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuReportes);
        setTitle("Java CRUD");
        setJMenuBar(menuBar);
        setSize(new Dimension (700,700));
        
        
        menuFile_Exit.addActionListener
        (new ActionListener(){
            public void actionPerformed (ActionEvent e){
                System.exit(0);
            }
            }
            );
        
        menuFile_NewFile.addActionListener
        (new ActionListener(){
            public void actionPerformed (ActionEvent e){
                MetodosCrud Nuevo=new MetodosCrud();
                Nuevo.show();
            }
            }
            );

        
        menuMantenimiento_Ingresar.addActionListener
        (new ActionListener(){
            public void actionPerformed (ActionEvent e){
                PersonRegistro();
            }
            }
            );
    }
   
    private static final long serialVersionUID = 1L;
    JTextField NamesField = new JTextField(" ", 30);
    JTextField ApellidoPaternoField = new JTextField(" ", 30);
    JTextField ApellidoMaternoField = new JTextField(" ", 30);
    JTextField EdadField = new JTextField(" ", 30);
    JTextField SexField = new JTextField(30);
    
    JButton goButton = new JButton("Exit");
    JButton addButton = new JButton("Add");
    JButton delButton = new JButton("Remove");
    JTable jTable;
    JScrollPane jSP;
    
    
    public void PersonRegistro() {
        setSize(500, 500);
        setTitle("Registro de los datos");
        setLocationRelativeTo(null);

        initForm();
        paintTable();
    }
    void initForm() {

        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][] {

        }, new String[] { "ID", "Name (s)", "Surname","Second surname","Age","Sex" }));
        jSP = new JScrollPane();
        jSP.setViewportView(jTable);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nombres"));
        add(NamesField);
        add(new JLabel("Apellido Paterno"));
        add(ApellidoPaternoField);
        add(new JLabel("Apellido Materno"));
        add(ApellidoMaternoField);
        add(new JLabel("Edad"));
        add(EdadField);
        add(new JLabel("Sexo"));
        add(SexField);
        add(addButton);
        add(delButton);
        add(jSP);
        add(goButton);
        final MetodosCrud outer = this;
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println(" goButton has press ");
                outer.setVisible(false);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson(e);
            }
        });
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delPerson(e);
            }
        });

    }
    void addPerson(ActionEvent e) {
        System.out.println(" addButton has press ");
        DatosPersona d = new DatosPersona();
        d.setNombres(NamesField.getText());
        d.setAp_paterno(ApellidoPaternoField.getText());
        d.setAp_materno(ApellidoMaternoField.getText());
        d.setEdad(EdadField.getText());
        d.setSexo(SexField.getText());
        IdP.create(d);
        paintTable();
    }
    void delPerson(ActionEvent e) {
        if (jTable.getSelectedRow() != -1) {
            System.out.println(" delButton has press ");
            int[] row = jTable.getSelectedRows();
            String ids = jTable.getValueAt(row[0], 0).toString();
            System.out.println("selected: " + ids);
            int id = Integer.parseInt(ids);
            try {
                IdP.delete(id);
            } catch (Exception ex) {
                Logger.getLogger(MetodosCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
            paintTable();
        }}
    
       private void paintTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        ArrayList<DatosPersona> listaPersona = IdP.list();
        while (modelo.getRowCount() > 0)
            modelo.removeRow(0);
        for (DatosPersona d : listaPersona) {
            modelo.addRow(new Object[] { d.getId(), d.getNombres(), d.getAp_paterno(),d.getAp_materno(),d.getEdad(), d.getSexo()
            });
        }
    }
}
