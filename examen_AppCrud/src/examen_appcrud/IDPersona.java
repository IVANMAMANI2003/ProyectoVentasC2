/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_appcrud;

import java.util.ArrayList;
import java.util.*;

import examen_appcrud.DatosPersona;

public class IDPersona {
    
    ArrayList<DatosPersona> listaPersona= new ArrayList<>();
    int id=0;    
    ArrayList<DatosPersona> ArrayList;
    
    public void create(DatosPersona p){
        id=id+1;
        p.setId(id);
        listaPersona.add((p));
    }
    public ArrayList<DatosPersona> list(){  //read
        return listaPersona;
    }
    public void delete(int id) throws Exception{
       
        Iterator<DatosPersona> itr = listaPersona.iterator();            
        while(itr.hasNext()){
            DatosPersona pers = itr.next();
            if(pers.getId()==(id)){
                System.out.println("Eliminando a: "+pers.getNombres());
                itr.remove();                    
            }
        }
}

    ArrayList<DatosPersona> ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
