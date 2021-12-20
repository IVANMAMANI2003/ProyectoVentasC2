package implementacion;

import conexion.ConexionDB;
import entidades.Cliente;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplCliente {
    
    ConexionDB cx= new ConexionDB();
    ArrayList<Cliente> listaClientes= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;    
    Persona ps = new Persona();
    
    Connection con;
    PreparedStatement prs;
    
    int r;
    public int  registrarCliente(Cliente c){
        
            int i=0;        
            try {
            query=" insert into cliente (cliente_id,tipo, cliente_persona_id) "+
                  " values('"+c.getCliente_id()+"','"+c.getCliente_tipo()+"','"+c.getCliente_persona_id()+"') ";
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        
        return i;
    }
    public Cliente BuscarCliente(int id){
        Cliente cl=new Cliente();
        String sql="SELECT * FROM clientes WHERE id";
        
         
        try {
            con = cx.conectaMysql();
            prs = con.prepareStatement(sql);
            prs.setInt(1, id);
            rset = prs.executeQuery();
        if (rset.next()) {
               cl.setCliente_id(rset.getString("cliente_id"));
               cl.setCliente_tipo(rset.getString("cliente_nombre"));
               cl.setCliente_persona_id(rset.getString("cliente_persona_id"));
               
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return cl;
}
}
