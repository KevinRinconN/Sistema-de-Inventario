/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author kevin
 */

@Entity
@Table(name= "RegistroProducto")
public class RegistroProducto implements Serializable{
    
    // id del registro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;
    // Codigo del producto
    private Integer codigo;
    // Nombre del producto
    private String nombre;
    // Precio del producto
    private Double precio;
    // Inventario del producto
    private Integer inventario;
    // Accion que se realizo
    private String accion;
    //fecha en la que se realizo
    private String fecha;
    //Hora actual en la que se realizo
    private String hora;
    
    
    
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
            
            
    public RegistroProducto() {
    }
    

    public RegistroProducto(Integer codigo, String nombre, Double precio, Integer inventario, String accion, Usuario usuario, String fecha, String hora) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
        this.accion = accion;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "RegistroProducto{" + "idRegistro=" + idRegistro + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", inventario=" + inventario + ", accion=" + accion + ", usuario=" + usuario.getNombre() + '}';
    }
    
    
}
