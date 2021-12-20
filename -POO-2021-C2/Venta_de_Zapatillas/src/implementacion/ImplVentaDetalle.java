/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionDB;
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
import utils.Generator;

/**
 *
 * @author HP
 */
public class ImplVentaDetalle {
    
    
    
    ConexionDB cnx=new ConexionDB();
    String sql="";
    String query="";
    Statement stmt=null;
    ResultSet rset=null;
    Generator gn= new Generator();
    ArrayList<Venta> lisVenta=new ArrayList<>();
    Producto pr=new Producto();
    ArrayList<Producto> listaproducto=new ArrayList<>();
    Persona ps=new Persona();
    Connection con;
    PreparedStatement prs;
    int r;
    public int RegistrarVentaDetalle(VentaDetalle Dv){

       String sql = "insert into ventadetalle ( ventadetalle_idventa,ventadetalle_idproducto,ventadetalle_cantidad, ventadetalle_preciounit ) values (?,?,?,?)";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            
            prs.setInt(1, Dv.getIdVenta());
            prs.setString(2, Dv.getIdProducto());
            prs.setInt(3, Dv.getCantidad());
            prs.setDouble(4, Dv.getPrecioUnit());
            
            prs.executeUpdate();
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
}
