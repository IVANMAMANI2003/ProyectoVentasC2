/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionDB;
import entidades.Cliente;
import entidades.Persona;
import entidades.Producto;
import entidades.Venta;
import entidades.VentaDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Generator;

/**
 *
 * @author HP
 */
public class ImplVentas {
    ConexionDB cnx=new ConexionDB();
    String sql="";
    String query="";
    Statement stmt=null;
    ResultSet rset=null;
    Generator gn= new Generator();
    
    Producto pr=new Producto();
    ArrayList<Producto> listaproducto=new ArrayList<>();
    Persona ps=new Persona();
    Connection con;
    PreparedStatement prs;
    
   ImplVentaDetalle vDetalle=new ImplVentaDetalle();
   VentaDetalle detV=new VentaDetalle();
   
    int r;
    public String NroSerieVenta(){
        String serie="";
        String sql = " select max(venta_serie) from venta";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            rset = prs.executeQuery();
            while(rset.next()){
                serie=rset.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return serie;
    }
    public String IdVenta(){
        String idv="" ;
        String sql = "SELECT MAX(id) FROM ventas";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            rset = prs.executeQuery();
            
            if (rset.next()) {
                idv = rset.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return idv;
    }
 /*   public int registrarVenta(Venta V){
        
        int i=0;
        if (V != null) {
        
        try {
            query= " insert into venta(venta_id,venta_idcliente, venta_fecha,venta_monto, venta_serie"
                    +"values('"+V.getId()+"','"+V.getIdCliente()+"','"+V.getFecha()+"','"+V.getMonto()+"','"+V.getSerie()+"')";
        System.out.println("venta"+query);
        stmt= cnx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
        

      VentaDetalle detV=new VentaDetalle();
        String idVdetalle=gn.generatorId();
        detV.setIdDet(idVdetalle);
        detV.setIdVenta();
       
        vDetalle.RegistrarVentaDetalle(detV);                
        }
        return i;
    }
 */
public int RegistrarVenta(Venta v){
    Venta Venta=new Venta();
        String sql = "INSERT INTO venta (venta_id, venta_idcliente, venta_fecha, venta_monto, venta_serie) VALUES (?,?,?,?,?)";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1, v.getId());
            prs.setString(2, v.getIdCliente());
            prs.setString(3, v.getFecha());
            prs.setDouble(4, v.getMonto());
            prs.setString(5, v.getSerie());
            r=prs.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarVentaDetalle(VentaDetalle Dv){
        VentaDetalle VentaDetalle=new VentaDetalle();
       String sql = " INSERT INTO ventadetalle ( ventadetalle_id, ventadetalle_idventa, ventadetalle_idproducto, ventadetalle_cantidad, ventadetalle_preciounit ) VALUES (?,?,?,?,?)";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1, Dv.getIdDet());
            prs.setInt(1, Dv.getIdVenta());
            prs.setString(2, Dv.getIdProducto());
            prs.setInt(3, Dv.getCantidad());
            prs.setDouble(4, Dv.getPrecioUnit());
            
            prs.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
     
/*
    public ArrayList<VentaDetalle> reporteVentas(){
        
        try {
            sql=" select * from ventas";
            stmt= cnx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            
            while(rset.next()){
                Producto pr=new Producto();
                pr.setId(rset.getInt("venta_id"));
                pr.setIdCliente(rset.getString("venta_idcliente"));
                pr.setNombre(rset.getString("producto_nombre"));
                pr.setMarca(rset.getString("producto_marca"));
                pr.setColor(rset.getString("producto_color"));
                pr.setTalla(rset.getString("producto_talla"));
                pr.setStock(rset.getInt("producto_stock"));
                pr.setPrecio(rset.getDouble("producto_precio"));
                
                listaproducto.add(pr);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return listaproducto;
    }
    
  */

    public Venta BuscarVenta(int id){
        Venta cl = new Venta();
        String sql = "SELECT * FROM venta WHERE id = ?";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1, id);
            rset = prs.executeQuery();
            if (rset.next()) {
                cl.setId(rset.getInt("id"));
                cl.setIdCliente(rset.getString("cliente"));
                cl.setFecha(rset.getString("fecha"));
                cl.setMonto(rset.getDouble("total"));
                cl.setSerie(rset.getString("Serie"));
                
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }
   /* public List Listarventas(){
       ArrayList<Venta> ListaVenta = new ArrayList();
       String sql = "SELECT c.id AS id_cli, c.nombre, v.* FROM clientes c INNER JOIN ventas v ON c.id = v.cliente";
       try {
           con = cnx.conectaMysql();
           prs = con.prepareStatement(sql);
           rset = prs.executeQuery();
           while (rset.next()) {               
               Venta vent = new Venta();
               vent.setId(rset.getString("id"));
               vent.setIdCliente(rset.getString("cliente"));
               vent.setFecha(rset.getString("fecha"));
               vent.setMonto(rset.getString("total"));
               vent.setSerie(rset.getInt("Serie"));
               ListaVenta.add(vent);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaVenta;
   }*/
    
    public boolean ActualizarStock(int cant, int id){
        String sql = "UPDATE productos SET stock = ? WHERE id = ?";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1,cant);
            prs.setInt(2, id);
            prs.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    
}
