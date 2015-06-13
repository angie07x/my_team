/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.util.Date;

/**
 *
 * @author Josue
 */
public class Factura {
    private int id_Factura;
    private String fecha_Factura;
    private double total_Factura;

  public Factura() {
        total_Factura=0;
    }
  public void calcularTotal(double subtotal) {
      total_Factura+=subtotal;
  }
    public Factura(int id_Factura, String fecha_Factura, double total_Factura) {
        this.id_Factura = id_Factura;
        this.fecha_Factura = fecha_Factura;
        this.total_Factura = total_Factura;
    }

    public int getId_Factura() {
        return id_Factura;
    }

    public void setId_Factura(int id_Factura) {
        this.id_Factura = id_Factura;
    }

    public String getFecha_Factura() {
        return fecha_Factura;
    }

    public void setFecha_Factura(String fecha_Factura) {
        this.fecha_Factura = fecha_Factura;
    }

    public double getTotal_Factura() {
        return total_Factura;
    }

    public void setTotal_Factura(double total_Factura) {
        this.total_Factura = total_Factura;
    }

    
    }

   
  
  