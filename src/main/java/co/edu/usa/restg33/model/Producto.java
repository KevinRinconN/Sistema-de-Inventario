/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
/**
 * Productos de la base de datos
 * @author Kevin Rincon
 */

@Entity
@Table(name= "Producto")
public class Producto implements Serializable{
    
    // Codigo del producto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private double precio;
    private int inventario;

    public Producto() {
        
    }
    

    /**
     * Inicializacion de componentes 
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param inventario Total de produtos
     */
    public Producto( String nombre, double precio, int inventario) {
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
        
    }
    
    
    /**
     * 
     * @return Retorna el codigo del producto 
     */
    public Integer getCodigo() {
        return codigo;
    }
    
    /**
     * 
     * @param codigo Codigo del producto 
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    /**
     * 
     * @return Retorna el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return Retorna el precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * 
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * 
     * @return Retorna el total de productos en el inventario
     */
    public int getInventario() {
        return inventario;
    }

    /**
     * 
     * @param inventario Total de productos 
     */
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
    
    /**
     * 
     * @return Retorna un String con todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", inventario=" + inventario + '}';
    }
    
   
    
  
}
