/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ferna
 */
@Entity
public class Producto implements Serializable {
   @Id
   private long id;
   private String descripcion;
   private int stockMinomo;
   private int stockActual;
   private double iva;
   private double precioMinorista;
   private double precioMayorista;

    public Producto() {
    }

    public Producto(long id, String descripcion, int stockMinomo, int stockActual,  double precioMinorista, double precioMayorista) {
        this.id = id;
        this.descripcion = descripcion;
        this.stockMinomo = stockMinomo;
        this.stockActual = stockActual;
        
        this.precioMinorista = precioMinorista;
        this.precioMayorista = precioMayorista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStockMinomo() {
        return stockMinomo;
    }

    public void setStockMinomo(int stockMinomo) {
        this.stockMinomo = stockMinomo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecioMinorista() {
        return precioMinorista;
    }

    public void setPrecioMinorista(double precioMinorista) {
        this.precioMinorista = precioMinorista;
    }

    public double getPrecioMayorista() {
        return precioMayorista;
    }

    public void setPrecioMayorista(double precioMayorista) {
        this.precioMayorista = precioMayorista;
    }
   
   
   
   
}
