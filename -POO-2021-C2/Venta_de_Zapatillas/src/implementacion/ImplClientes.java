package implementacion;

import conexion.ConexionDB;
import entidades.Cliente;
import entidades.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Generator;

public class ImplClientes {
    
    ConexionDB cx= new ConexionDB();
    ArrayList<Persona> listaPersonas= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;
    
    Generator gn= new Generator();
    ImplCliente ic= new ImplCliente();
    Cliente cl= new Cliente();
    Connection con;
    PreparedStatement prs;
    int r;
    public int  registrarPersona(Cliente p){
        int i=0;
        //String idpersona=gn.generatorId();
        try {
            query=" insert into clientes (persona_id, persona_nombre,persona_ap_paterno,persona_ap_materno, persona_dni, persona_sexo,persona_celular, persona_direccion ) "+
                  " values('"+p.getId()+"','"+p.getNombre()+"','"+p.getAp_paterno()+"','"+p.getAp_materno()+"','"+p.getDni()+"','"+p.getSexo()+"','"+p.getCelular()+"','"+p.getDireccion()+"') ";
            System.out.println("ssss"+query);
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage()); 
        }       
        
        
        String idcliente=gn.generatorId();
        cl.setCliente_id(idcliente);
        cl.setCliente_tipo("A");
        //cl.setCliente_persona_id();        
        ic.registrarCliente(cl);                
        
        return i;
    }
    
    public ArrayList<Persona> reportePersonas(){
        try {
            sql=" select * from clientes ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                Persona ps = new Persona();
                ps.setId(rset.getInt("persona_id"));
                ps.setNombre(rset.getString(2));
                ps.setAp_paterno(rset.getString(3));
                ps.setAp_materno(rset.getString(4));
                ps.setDni(rset.getInt(5));
                listaPersonas.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaPersonas;
    }
    
    public int eliminarRegistroPersona(String sid){
        
        int i=0;
        try {
            sql=" delete from clientes where persona_id='"+sid+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("Se elimino el registro");
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
    }
    
    public int actualizarRegistroPersona(Persona p){
        
        int i=0;
        try {
            sql=" update  clientes " +
                " set persona_nombre='"+p.getNombre()+"', persona_ap_paterno='"+p.getAp_paterno()+"', persona_ap_materno='"+p.getAp_materno()+"', persona_codigo='"+p.getDni()+"' " +
                " where persona_id  ='"+p.getId()+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
        
    }
    
    public Persona reportePersonaUnico(String sid){
        Persona ps = new Persona();
        try {
            sql=" select * from clientes where persona_id='"+sid+"' ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
                ps.setId(rset.getInt("persona_id"));
                ps.setNombre(rset.getString(2));
                ps.setAp_paterno(rset.getString(3));
                ps.setAp_materno(rset.getString(4));
                ps.setDni(rset.getInt(5));                
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return ps;
    }
    
    public Persona reportePersonaUnico(String scodigo, String a){
        Persona ps = new Persona();
        try {
            sql=" select * from clientes where persona_codigo='"+scodigo+"' ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
                ps.setId(rset.getInt("persona_id"));
                ps.setNombre(rset.getString(2));
                ps.setAp_paterno(rset.getString(3));
                ps.setAp_materno(rset.getString(4));
                ps.setDni(rset.getInt(5));                
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return ps;
    }
    /*
    public Persona LoginReportePersonaUnico(String slogin, String spassword){
        Persona ps = new Persona();        
        try {
            sql=" select * from clientes where persona_usuario='"+slogin+"' and  persona_password='"+spassword+"' ";
            System.out.println("consulta:"+sql);
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            ps.setAcceso(false);
            if(rset.next()){
                System.out.println("dentro del ifff de la consulta:");
                ps.setId(rset.getInt("persona_id"));
                ps.setSexo(rset.getString("persona_sexo"));
                ps.setNombre(rset.getString("persona_nombre"));
                ps.setAp_paterno(rset.getString("persona_ap_paterno"));
                ps.setAp_materno(rset.getString("persona_ap_materno"));
                ps.setDni(rset.getInt("persona_dni"));
                ps.setUsuario(rset.getString("persona_usuario"));
                ps.setPassword(rset.getString("persona_password"));
                ps.setAcceso(true);
            }
        } catch (SQLException ex) {
                ex.getMessage();
                System.out.println("errrorrrrr:"+ex.getMessage());
        }
        return ps;
    }
    */
    public Persona listarId(int id){
        Persona ps=new Persona();
        String sql = "select * from clientes where persona_id = ?";
        try {
            con=cx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1, id);
            rset = prs.executeQuery();
            while(rset.next()){
                
                ps.setId(rset.getInt("persona_id"));
                
                ps.setNombre(rset.getString("persona_nombre"));
                ps.setAp_paterno(rset.getString("persona_ap_paterno"));
                ps.setAp_materno(rset.getString("persona_ap_materno"));
                ps.setDni(rset.getInt(5));
                ps.setSexo(rset.getString("persona_sexo"));
                ps.setUsuario(rset.getString("persona_usuario"));
                ps.setPassword(rset.getString("persona_password"));
                
    
            }
        } catch (Exception e) {
        }
        return ps;
    }
    
}
