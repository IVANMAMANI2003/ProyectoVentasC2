/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
int row=jTableProducto.getSelectedRow();
       
        String nombre = jTableProducto.getValueAt(row, 2).toString();
        String marca  = jTableProducto.getValueAt(row, 3).toString();
        String modelo  = jTableProducto.getValueAt(row, 4).toString();        
        String stock  = jTableProducto.getValueAt(row, 5).toString();
        String precio  = jTableProducto.getValueAt(row, 6).toString();
        
        System.out.println("Holasss"+nombre+marca+modelo+stock+precio);
        P_nombre.setText(nombre);
        P_marca.setText(marca);
        P_modelo.setText(modelo);       
        P_stock.setText(stock);
        P_precio.setText(precio);
        
        Producto pro= new Producto();
       
        pro.setNombre(nombre);
        pro.setMarca(marca);
        pro.setModelo(modelo);
        pro.setStock(Integer.parseInt(stock));
        pro.setPrecio(precio);
        
        
        
              
    }         
 */
package interfacesDao;

import entidades.Producto;
import java.util.ArrayList;

public interface InterProductoDao {
    
    public int  registrarProd(Producto P);
    public int  ActualizarProd(Producto pAc);
    public int  ActualizarStock(int cant, int id);
    public ArrayList<Producto> reporteProd();
    public ArrayList<Producto> reporteProduc();
    public int eliminarProducto(String nombre);

    
}


