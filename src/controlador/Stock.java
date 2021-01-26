/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.VistaInicio;

/**
 *
 * @author ferna
 */
public class Stock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persistencia persistencia = new Persistencia();
        Controlador controlador = new Controlador(persistencia);
        VistaInicio inicio = new VistaInicio(controlador);
        inicio.setVisible(true);
        
        
    }
    
}
