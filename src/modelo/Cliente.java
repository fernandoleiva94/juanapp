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
public class Cliente implements Serializable {
    
   @Id
   private long dni;
   private String razon;
   private String telefono;
   private String mail;

    
 
    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Cliente( long dni, String razon, String telefono, String mail) {
       // this.id = id;
        this.dni = dni;
        this.razon = razon;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Cliente() {
    }
   
   
   
   
   
   
   
}
