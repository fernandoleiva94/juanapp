/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.*;
import modelo.Cliente;
import modelo.Producto;

/**
 *
 * @author ferna
 */
public class Controlador {

    Persistencia persistencia;

    public Controlador(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public void GuardarObjeto(Object objeto) {
        this.persistencia.GuardarObjeto(objeto);

    }

    public Cliente BuscarClienteDni(String id) {
        return persistencia.BuscarCliente(id);
    }

    public List<Cliente> BuscarClienteLista(String nombre) {
        return persistencia.BuscarClienteLista(nombre);
    }
    
     public List<Cliente> BuscarClienteTodos() {
        return persistencia.BuscarClienteTodos();
    }
     
     public Producto BuscarProductoCodigo(Long cod){
     
     return persistencia.BuscarProductoCodigo(cod);
     }

}
