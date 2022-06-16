/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kevin
 */
@Entity
@Table(name= "Usuario")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombre;
    private String correo;
    private String contraseña;
    private String rango;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="usuario")
    private List<RegistroProducto> historialProductos;
    
    public Usuario() {
    }

    
    public Usuario(String nombre, String correo, String contraseña, String rango) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rango = rango;
    }
    
    public void agregarRegistro (RegistroProducto registro){
       
        if(historialProductos==null) historialProductos = new ArrayList<>();
        
        historialProductos.add(registro);
        
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String isAdmin() {
        return rango;
    }

    public void setAdmin(String rango) {
        this.rango = rango;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public List<RegistroProducto> getHistorialProductos() {
        return historialProductos;
    }

    public void setHistorialProductos(List<RegistroProducto> historialProductos) {
        this.historialProductos = historialProductos;
    }
    
    
    
    
}
