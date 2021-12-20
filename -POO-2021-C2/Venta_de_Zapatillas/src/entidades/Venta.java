/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;


public class Venta {
    
   private int id;
   private String idCliente;
   private String fecha;
    private double monto;
    private String serie;
    private ArrayList<VentaDetalle> Vdetalle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

   

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }


    public ArrayList<VentaDetalle> getVdetalle() {
        return Vdetalle;
    }

    public void setVdetalle(ArrayList<VentaDetalle> Vdetalle) {
        this.Vdetalle = Vdetalle;
    }

 
    
}
