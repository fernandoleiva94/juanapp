/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ferna
 */
public class DetalleVenta {
    private Venta venta;
    private int renglon;
    private Producto producto;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleVenta(Venta venta, int renglon, Producto producto) {
        this.venta = venta;
        this.renglon = renglon;
        this.producto = producto;
    }

    public DetalleVenta() {
    }
    
    
    
    
    
    
    
}
