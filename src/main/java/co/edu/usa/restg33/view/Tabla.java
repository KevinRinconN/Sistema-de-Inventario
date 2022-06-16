/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Tabla de los productos
 *
 * @author Kevin Rinon
 */
public class Tabla extends JPanel {

    /**
     * Lista de los productos ingresados
     */
    private List<InterfazProducto> listaProductos;
    /**
     * Imagen del panel
     */
    private Image imagen;

    /**
     * Constructor de la tabla
     */
    public Tabla() {
        //Se inicicializa la lista
        listaProductos = new ArrayList<InterfazProducto>();
        // Se define el color del panel
        setBackground(new Color(25, 25, 25));
        // se quita el layout 
        setLayout(null);

    }

    /**
     * Añadir una imagen al panel
     *
     * @param g G
     */
    public void paint(Graphics g) {

        imagen = new ImageIcon("panelTabla.png").getImage();
        this.setOpaque(false);
        g.drawImage(imagen, 0, 0, 886, getHeight(), this);
        super.paint(g);
    }

    /**
     * Agrega productos a la lista
     *
     * @param producto
     */
    public void agregarProducto(InterfazProducto producto) {
        listaProductos.add(producto);
        this.add(producto);
        ordenarTabla();
    }

    public void buscarProducto(String productoBuscar) {

        this.removeAll();
        for (InterfazProducto producto : listaProductos) {
            this.add(producto);
        }

        if (productoBuscar == null) {
            ordenarTabla();
        } else {
            
            for (InterfazProducto producto : listaProductos) {
                if (!producto.getProducto().getNombre().equals(productoBuscar)) {

                    this.remove(producto);
                    
                    
                }else{
                    producto.definirPosicion(30);
                    this.updateUI();
                }

            }
            
            
        }

    }

    /**
     * Ordena los label, asignando la posicion vertical dentro del panel
     */
    public void ordenarTabla() {

        int posicionVertical = 30;
        int numeroPosicion = 1;

        for (InterfazProducto producto : listaProductos) {
            if (!producto.isSeleccionado()) {
                producto.setPosicion(numeroPosicion);
            }
            producto.definirPosicion(posicionVertical);
            numeroPosicion++;

            posicionVertical += 60;
        }

        this.setPreferredSize(new Dimension(830, posicionVertical));
        this.updateUI();
    }

    /**
     * Define que el unico componente seleccionado sea el ingresado
     *
     * @param productoSeleccionado InterfazProducto
     */
    public void unicaSeleccionada(InterfazProducto productoSeleccionado) {

        for (InterfazProducto producto : listaProductos) {
            if (productoSeleccionado.getProducto().getCodigo() != producto.getProducto().getCodigo()) {
                producto.setProductoImagen();
                producto.setSeleccionado(false);
                producto.definirColorTexto(producto.getColorDefault());
            }
        }

    }

    /**
     *
     * @return Retorna la lista de los productos
     */
    public List<InterfazProducto> getListaProductos() {
        return listaProductos;
    }

    /**
     *
     * @return Retorna el producto con el precio mayor
     */
    public String productoMayor() {

        InterfazProducto productoMayor = listaProductos.get(0);

        for (InterfazProducto producto : listaProductos) {
            if (producto.getProducto().getPrecio() > productoMayor.getProducto().getPrecio()) {
                productoMayor = producto;
            }

        }

        return productoMayor.getProducto().getNombre();
    }

    /**
     *
     * @return Retorna el producto con el precio menor
     */
    public String productoMenor() {

        InterfazProducto productoMenor = listaProductos.get(0);

        for (InterfazProducto producto : listaProductos) {
            if (producto.getProducto().getPrecio() < productoMenor.getProducto().getPrecio()) {
                productoMenor = producto;
            }

        }

        return productoMenor.getProducto().getNombre();
    }

    /**
     *
     * @return Retorna el promedio de los precios de todos los productos
     * ingresados
     */
    public double promedioPrecios() {

        double promedioPrecio = 0;

        for (InterfazProducto producto : listaProductos) {

            promedioPrecio += producto.getProducto().getPrecio();

        }

        return promedioPrecio;
    }

    /**
     *
     * @return Retorna el valor total del inventario de todos los productos
     * ingresados
     */
    public double valorInventario() {

        double valorTotal = 0;

        for (InterfazProducto producto : listaProductos) {

            valorTotal += producto.getProducto().getPrecio() * producto.getProducto().getInventario();

        }

        return valorTotal;
    }

    /**
     *
     * @param nombre Nombre del producto
     * @return Retorna un boolean para saber si el producto exite en la base de
     * datos
     */
    public boolean verificarExistencia(String nombre) {

        boolean verificador = false;

        for (InterfazProducto producto : listaProductos) {

            if (producto.getProducto().getNombre().equals(nombre)) {

                verificador = true;

            }

        }
        return verificador;
    }

    /**
     * Define la lista de productos
     *
     * @param listaProductos Lista de productos
     */
    public void setListaProductos(List<InterfazProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
