/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */
public class DetalleFactura {
    private int id_Detalle;
    private Factura factura;
    private String nombre_Producto;
    private int cantidad;
    private double precio_Unitario;
    private double subtotal;
private List<DetalleFactura>lstDetalle;
    public DetalleFactura() {
        
        lstDetalle=new ArrayList();
    }

    public DetalleFactura(int id_Detalle, Factura factura, String nombre_Producto, int cantidad, double precio_Unitario, double subtotal) {
        this.id_Detalle = id_Detalle;
        this.factura = factura;
        this.nombre_Producto = nombre_Producto;
        this.cantidad = cantidad;
        this.precio_Unitario = precio_Unitario;
        this.subtotal = cantidad * precio_Unitario;
    }

    public int getId_Detalle() {
        return id_Detalle;
    }

    public void setId_Detalle(int id_Detalle) {
        this.id_Detalle = id_Detalle;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(double precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
  public List<DetalleFactura> getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(List<DetalleFactura> lstDetalle) {
        this.lstDetalle = lstDetalle;
    }
    
        
    

   
    
}
