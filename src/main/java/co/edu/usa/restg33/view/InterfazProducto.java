/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;


import co.edu.usa.restg33.model.Producto;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * JLabel que contiene y muestra los diferens valores de producto de manera grafica
 * @author Kevin Ricon
 */
public class InterfazProducto extends JLabel {
    
    /**
     * Objeto de la clase producto
     */    
    private Producto producto;
    /**
     * Posicion de la tabla
     */
    private int posicion;
    /**
     * Boolean para saber si el producto fue seleccionado
     */
    private boolean seleccionado;
    /**
     * JLabel donde estaran la informacion de los productos
     */
    private JLabel detalleProducto;
    /**
     * JLabel que contendra la posicion en la tabla y borrara los productos
     */
    private JLabel posicionOperador;
    /**
     * Imagen para actualizar detalleProducto
     */
    private ImageIcon actualizarProducto;
    /**
     * Imagen para actualizar posicionOperador
     */
    private ImageIcon actualizarPosicion;
    /**
     * Imagen para eliminar la posicionOperador
     */
    private ImageIcon eliminarPosicion;
    /**
     * Imagen para eliminar el detalleProducto
     */
    private ImageIcon eliminarProducto;
    /**
     * Imagen por defecto de detalleProducto
     */
    private ImageIcon defaultProducto;
    /**
     * Imagen por defecto de posicionOperador
     */
    private ImageIcon defaultPosicion;
    /**
     * JLabel del numero de la posicion del producto
     */
    private JLabel textoNumero;
    /**
     * JLabel del nombre del producto
     */
    private JLabel textoNombre;
    /**
     * JLabel del precio del producto
     */
    private JLabel textoPrecio;
    /**
     * JLabel del inventario del producto
     */
    private JLabel textoInventario;
    /**
     * JLabel del precion total del inventario del producto
     */
    private JLabel textoTotalInventario;
    /**
     * Color por defecto del texto en los JLabels
     */
    private Color colorDefault;
    /**
     * Color del texto cuando se usen la imagenes de eliminar y actualizar
     */
    private Color colorContraste;
    
    
    /**
     * Constructor para inicializar componentes
     * @param producto Producto 
     */
    public InterfazProducto (Producto producto){
        this.producto = producto;
        inicializarComponentes();
    
    }
    
    /**
     * Metodo para inicializar componentes
     */
    private void inicializarComponentes (){
        
        // Se define el tamaño y posicion del label
        this.setBounds(20, 10, 868, 50);
        // Se define el color del Label
        this.setBackground(new Color (13,13,13));
        
        actualizarProducto = new ImageIcon ("actualizarProducto.png");
        actualizarPosicion = new ImageIcon ("actualizarPosicion.png");
        eliminarPosicion = new ImageIcon ("posicionEliminar.png");
        eliminarProducto = new ImageIcon ("productoEliminar.png");
        defaultProducto = new ImageIcon ("producto.png");
        defaultPosicion = new ImageIcon ("posicion.png");
        
        colorDefault = new Color (118,113,113);
        colorContraste = new Color (59,56,56);
        
                
                
        
        detalleProducto = Configuracion.imagen(defaultProducto, 55, 0, 768, 44);
        posicionOperador = Configuracion.imagen(defaultPosicion, 0, 0, 45, 44);
        
        posicionOperador.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        textoNumero = Configuracion.texto(Integer.toString(posicion), 0 , 0, 45, 44, 20, colorDefault, SwingConstants.CENTER);
        // Configurazion del Jlabel del nombre
        textoNombre = Configuracion.texto(producto.getNombre(), 70, 0, 150, 45, 15, colorDefault ) ;
        // Configuracion del JLabel de precio
        textoPrecio = Configuracion.texto(Double.toString(producto.getPrecio()), 277, 0, 150, 45, 15, colorDefault);
        // Configuraxion del JLabel del inventario
        textoInventario = Configuracion.texto(Integer.toString(producto.getInventario()), 494, 0, 150, 45, 15, colorDefault);
        // Configuracion del JLabel del precio total del inventario del produto
        textoTotalInventario = Configuracion.texto(Double.toString(producto.getPrecio()*producto.getInventario()), 665, 0, 150, 45, 15, colorDefault);
        
        
        posicionOperador.add(textoNumero);
        
        
        detalleProducto.add(textoNombre);
        detalleProducto.add(textoPrecio);
        detalleProducto.add(textoInventario);
        detalleProducto.add(textoTotalInventario);
        
    
        this.add(posicionOperador);
        this.add(detalleProducto);
    }
    
    /**
     *  Actualizar los JLabel con los valores ya actualizados 
     */
    public void actualizarProducto (){
        
        textoNombre.setText(producto.getNombre());
        textoPrecio.setText(Double.toString(producto.getPrecio()));
        textoInventario.setText(Integer.toString(producto.getInventario()));
        textoTotalInventario.setText(Double.toString(producto.getPrecio()*producto.getInventario()));
        
    }
    
    /**
     * Definir la imagen por defecto de los JLabel
     */
    public void setProductoImagen (){
        detalleProducto.setIcon(defaultProducto);
        posicionOperador.setIcon(defaultPosicion);
        textoNumero.setText(Integer.toString(posicion));
    }
    
    /**
     * Definir el color del texto 
     * @param color Color del texto
     */
    public void definirColorTexto (Color color){
        textoNombre.setForeground(color);
        textoPrecio.setForeground(color);
        textoInventario.setForeground(color);
        textoTotalInventario.setForeground(color);
    }
    /**
     * Definir posicion vertical de la clase
     * @param posicionVertical Posicion vertical
     */
    public void definirPosicion (int posicionVertical){
        this.setBounds(30, posicionVertical, 868, 50);
    }

    /**
     * si el producto se encuentra seleccionado o no
     * @return Boolean
     */
    public boolean isSeleccionado() {
        return seleccionado;
    }
    
    /**
     * Definir la seleccion del producto
     * @param seleccionado Seleccionado
     */
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    /**
     * Posicion en la tabla
     * @return La posicion dentro de la tabla 
     */
    public int getPosicion() {
        return posicion;
    }
    
    /**
     * Definir el numero de la posicion en la tabla
     * @param posicion Numero de la posicion en la tabla
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
        textoNumero.setText(Integer.toString(posicion));
    }

    /**
     * 
     * @return Retorna el JLabel de la informacion del producto
     */
    public JLabel getDetalleProducto() {
        return detalleProducto;
    }
    
    /**
     * Definir el JLabel de la informacion del producto
     * @param detalleProducto JLbael de la informacion del producto
     */
    public void setDetalleProducto(JLabel detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    /**
     * 
     * @return Retorna el JLabel que contiene le la posicion del producto en la tabla
     */
    public JLabel getPosicionOperador() {
        return posicionOperador;
    }
    
    /**
     * Definir el JLabel que contiene le la posicion del producto en la tabla
     * @param posicionOperador JLabel que contiene le la posicion del producto en la tabla 
     */
    public void setPosicionOperador(JLabel posicionOperador) {
        this.posicionOperador = posicionOperador;
    }

    /**
     * 
     * @return Retorna la imagen de actualizar del JLabel detalleProducto
     */
    public ImageIcon getActualizarProducto() {
        return actualizarProducto;
    }

    /**
     * 
     * @return Retorna la imagen de actualizar del JLabel posicionOperador
     */
    public ImageIcon getActualizarPosicion() {
        return actualizarPosicion;
    }

    /**
     * 
     * @return Retorna la imagen de eliminar del JLabel detalleProducto
     */
    public ImageIcon getEliminarPosicion() {
        return eliminarPosicion;
    }

    /**
     * 
     * @return Retorna la imagen de eliminar del JLabel posicionOperador
     */
    public ImageIcon getEliminarProducto() {
        return eliminarProducto;
    }

    /**
     * 
     * @return Retorna la imagen por defecto del JLabel detalleProducto
     */
    public ImageIcon getDefaultProducto() {
        return defaultProducto;
    }

    /**
     * 
     * @return Retorna la imagen por defecto del JLabel posicionOperador
     */
    public ImageIcon getDefaultPosicion() {
        return defaultPosicion;
    }

    /**
     * 
     * @return Retorna el producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Define el producto
     * @param producto Producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Definir JLabel del numero de la posicion
     * @param textoNumero JLabel del numero de la posicion
     */
    public void setTextoNumero(JLabel textoNumero) {
        this.textoNumero = textoNumero;
    }

    /**
     * JLabel del nombre
     * @param textoNombre JLabel del nombre
     */
    public void setTextoNombre(JLabel textoNombre) {
        this.textoNombre = textoNombre;
    }

    /**
     * JLabel del precio
     * @param textoPrecio JLabel del precio 
     */
    public void setTextoPrecio(JLabel textoPrecio) {
        this.textoPrecio = textoPrecio;
    }

    /**
     * JLabel del inventario
     * @param textoInventario JLabel del inventario
     */
    public void setTextoInventario(JLabel textoInventario) {
        this.textoInventario = textoInventario;
    }

    /**
     * Definir el JLabel del total del inventario
     * @param textoTotalInventario JLabel del total del inventario
     */
    public void setTextoTotalInventario(JLabel textoTotalInventario) {
        this.textoTotalInventario = textoTotalInventario;
    }

    /**
     * 
     * @return Retorna el JLabel de la posicion del producto en la tabla
     */
    public JLabel getTextoNumero() {
        return textoNumero;
    }

    /**
     * 
     * @return Retorna el JLabel del nombre
     */
    public JLabel getTextoNombre() {
        return textoNombre;
    }

    /**
     * 
     * @return Retorna el JLabel del precio
     */
    public JLabel getTextoPrecio() {
        return textoPrecio;
    }

    /**
     * 
     * @return Retorna el JLabel del inventario
     */
    public JLabel getTextoInventario() {
        return textoInventario;
    }

    /**
     * 
     * @return Retorna el color por defecto del texto 
     */
    public Color getColorDefault() {
        return colorDefault;
    }

    /**
     * Definir el color por defecto del texto
     * @param colorDefault Color por defecto del texto
     */
    public void setColorDefault(Color colorDefault) {
        this.colorDefault = colorDefault;
    }

    /**
     * 
     * @return Color de contraste 
     */
    public Color getColorContraste() {
        return colorContraste;
    }

    /**
     * Define el color contraste del texto
     * @param colorContraste Color contraste
     */
    public void setColorContraste(Color colorContraste) {
        this.colorContraste = colorContraste;
    }
    
    
    
}
