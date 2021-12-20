/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionDB;

import entidades.Producto;
import interfacesDao.InterProductoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Generator;

public class ImplProducto implements InterProductoDao  {
    ConexionDB cnx=new ConexionDB();
    String sql="";
    String query="";
    Statement stmt=null;
    ResultSet rset=null;
    Generator gn= new Generator();
    ArrayList<Producto> listaproducto=new ArrayList<>();
    Producto pr=new Producto();
    Connection con;
    PreparedStatement prs;
    int r;
    public int registrarProd(Producto P){
        
        int i=0;
            
        try {
            query= " insert into producto (producto_id, producto_nombre, producto_marca,"
                    + " producto_color, producto_talla, producto_stock, producto_precio)"+
                    "values('"+P.getId()+"','"+P.getNombre()+"','"+P.getMarca()+"','"+P.getColor()+"','"+P.getTalla()+"','"+P.getStock()+"','"+P.getPrecio()+"')";
        System.out.println("prod"+query);
        stmt= cnx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
        
        return i;
    }
    
    public ArrayList<Producto> reporteProd(){
        
        try {
            sql=" select * from producto";
            stmt= cnx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            
            while(rset.next()){
                Producto pr=new Producto();
                pr.setId(rset.getInt("producto_id"));
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
    public Producto listarId(int id){
        Producto pr=new Producto();
        String sql = "select * from producto where producto_id = ?";
        try {
            con=cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1, id);
            rset = prs.executeQuery();
            while(rset.next()){
                
                pr.setId(rset.getInt(1));
                pr.setNombre(rset.getString("producto_nombre"));
                pr.setMarca(rset.getString("producto_marca"));
                pr.setColor(rset.getString("producto_color"));
                pr.setTalla(rset.getString("producto_talla"));
                pr.setStock(rset.getInt("producto_stock"));
                pr.setPrecio(rset.getDouble("producto_precio"));
    
            }
        } catch (Exception e) {
        }
        return pr;
    }
   /*  public ArrayList<Producto> reporteProduc(){
        
        try {
            sql=" select * from producto";
            stmt= cnx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            
            while(rset.next()){
                Producto pr=new Producto();
                pr.setId(rset.getString("producto_id"));
                pr.setNombre(rset.getString("producto_nombre"));
                pr.setMarca(rset.getString("producto_marca"));
                pr.setModelo(rset.getString("producto_modelo"));
                pr.setStock(rset.getInt("producto_stock"));
                pr.setPrecio(rset.getDouble("producto_precio"));
                
                listaproducto.add(pr);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return listaproducto;
    }*/

    public int ActualizarProd(Producto pAc){
        int i=0;
       
        try {
            query=" update producto"+
                " set producto_nombre='"+pAc.getNombre()+"',producto_marca='"+pAc.getMarca()+"',producto_color='"+pAc.getColor()+"',producto_talla='"+pAc.getTalla()+"',producto_stock='"+pAc.getStock()+"',producto_precio='"+pAc.getPrecio()+"'  "+ 
            " where producto_id='"+pAc.getId()+"' ";
            stmt= cnx.conectaMysql().createStatement();
            i=stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
        
        return i;
    }
    

   public int eliminarProducto(String nombre){
        
         int i=0;
        try {
            query="delete from producto where producto_nombre='"+nombre+"'";  
            stmt= cnx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        return i;
    }
   
   public Producto BuscarProd(String id){
        Producto producto = new Producto();
        String sql = "SELECT * FROM productos WHERE id = ?";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setString(1, id);
            rset = prs.executeQuery();
            if (rset.next()) {
                producto.setId(rset.getInt("id"));
                producto.setNombre(rset.getString("nombre"));
                producto.setMarca(rset.getString("marca"));
                producto.setColor(rset.getString("color"));
                producto.setTalla(rset.getString("talla"));
                producto.setStock(rset.getInt("stock"));
                producto.setPrecio(rset.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
    public int ActualizarStock(int cant, int id){
        String sql = "UPDATE productos SET stock = ? WHERE id = ?";
        try {
            con = cnx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1,cant);
            prs.setInt(2, id);
            prs.execute();
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            
        }
        return r;
    
    }
/*
   public Producto reporteProductoUnico(String sid, String a){
        Producto pr = new Producto();
        try {
            sql=" select * from producto where producto_nombre='"+sid+"' ";
            stmt=cnx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
                pr.setId(rset.getString("producto_id"));
                pr.setNombre(rset.getString(2));
                pr.setMarca(rset.getString(3));
                pr.setModelo(rset.getString(4));
                pr.setStock(rset.getInt(5));      
                pr.setPrecio(rset.getString(6)); 
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return pr;
    }*/

    @Override
    public ArrayList<Producto> reporteProduc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

