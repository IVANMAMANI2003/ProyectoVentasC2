/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_appcrud;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class MetodosSistema {
     public ArrayList<String> listaPersona= new ArrayList<>();
    public void registrarPersona (Object x){
        listaPersona.add((String) x);
    }
}
