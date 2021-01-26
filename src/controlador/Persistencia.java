/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import error.NotificarError;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author ferna
 */
public class Persistencia {

    private final String configuracion = "hibernate/hibernate.cfg.xml";
    private SessionFactory factory;  // PERMITE CREAR CONECCIONES A LA BSE DE DATOS CADA VEZ QUE NECESITEMOS
    private Session sesion;
    private Configuration config;

    public Persistencia() {
        try {
            this.CrearConexion();
        } catch (HibernateException e) {
            //  throw new NotificarErrores (e.getMessage());
        }
    }

    private void CrearConexion() {
        try {
            config = new Configuration();
            config.configure(this.configuracion);
            System.out.println("configuracion exitosa");
            this.factory = config.buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void comprobarSecion() {
        this.ComprobarSesion();
    }

    protected void ComprobarSesion() {
        String mensaje;
        try {
            if (this.factory.isClosed()) {
                //se intenta abrir la conexion;
                this.CrearConexion();
            }
            if (this.sesion == null || !this.sesion.isConnected()) {
                this.sesion = this.factory.openSession();
            }
        } catch (HibernateException e) {
            mensaje = "Se ha interrumpido la conexión con la base de datos";

        }
    }

    public void GuardarObjeto(Object obj) {

        String mensaje = null;
        //se comprueba la sesion
        this.ComprobarSesion();
        Transaction tx = this.sesion.beginTransaction();
        try {
            this.sesion.saveOrUpdate(obj);
            tx.commit();          // finaliza la transaccion guardando
        } catch (HibernateException e) {

            // si hay algun error rollback elimina las instancias creadas hasta el momento
            System.out.println(e.getMessage());
            tx.rollback();

        }
        this.sesion.close();

    }

    public Object BuscarObjeto(String id) {
        Object obj = null;

        this.ComprobarSesion();
        // obj = this.sesion.createQuery(id,intancia.getClass());
        //
        Cliente cliente = (Cliente) this.sesion.createQuery("FROM Cliente WHERE dni = :id").setParameter("id", Long.parseLong("1234")).uniqueResult();
        System.out.println(cliente);
        // List<Comprobante> comprobante  = this.sesion.createQuery("FROM Comprobante AS c WHERE c.fecha BETWEEN :fecha1 AND :fecha2").setParameter("fecha1",fecha1).setParameter("fecha2", fecha2).list();

        return obj;
        //return comprobante;*/
    }

    public Cliente BuscarCliente(String dni) throws HibernateException {
        Cliente cli = null;
        try {
            this.ComprobarSesion();
            cli = (Cliente) sesion.createQuery("SELECT c FROM Cliente c WHERE c.dni=:id").setParameter("id", Long.parseLong(dni)).uniqueResult();
            return cli;
        } catch (HibernateException e) {

            //throw new NotificarError(e.getMessage());
            return cli;
        }
    }

    public List<Cliente> BuscarClienteLista(String nombre) {

        List <Cliente> cli = null;
        try {
            this.ComprobarSesion();
            //cli =  sesion.createQuery("SELECT c FROM Cliente c WHERE c.dni LIKE '%:nom%'").setParameter("nom",nombre).list();
            cli = sesion.createQuery("SELECT c FROM Cliente c WHERE c.razon LIKE :nom").setParameter("nom", "%" + nombre + "%").list();
            sesion.close();
            return cli;
        } catch (HibernateException e) {
            sesion.close();
            //throw new NotificarError(e.getMessage());
            return cli;
        }

    }
    
    
        public List<Cliente> BuscarClienteTodos() {

        List <Cliente> cli = null;
        try {
            this.ComprobarSesion();
            //cli =  sesion.createQuery("SELECT c FROM Cliente c WHERE c.dni LIKE '%:nom%'").setParameter("nom",nombre).list();
            cli = sesion.createQuery("SELECT c FROM Cliente c").list();
            sesion.close();
            return cli;
        } catch (HibernateException e){
            sesion.close();
            //throw new NotificarError(e.getMessage());
            return cli;
        }

    }
        
        
        public Producto BuscarProductoCodigo(Long cod){
            this.ComprobarSesion();
            Producto p ;
            p = (Producto) sesion.createQuery("SELECT c FROM Producto c WHERE c.id = :cod").setParameter("cod",cod).uniqueResult();
         sesion.close();
        return p;
        }

}
