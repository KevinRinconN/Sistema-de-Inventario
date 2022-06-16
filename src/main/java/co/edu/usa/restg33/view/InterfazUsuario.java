/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import co.edu.usa.restg33.model.Usuario;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author kevin
 */
public class InterfazUsuario extends JLabel {
    
    private Usuario usuario;
    private JLabel imagenUsuario;
    private JLabel imagenPosicion;
        /**
     * Color por defecto del texto en los JLabels
     */
    private Color colorDefault;
    /**
     * Color del texto cuando se usen la imagenes de eliminar y actualizar
     */
    private Color colorContraste;
    
    private JLabel nombre;
    private JLabel correo;
    private JLabel rango;
    
    private ImageIcon defaultImagen;
    private ImageIcon defaultPosicion;
    private ImageIcon eliminarUsuarioImagen;
    private ImageIcon eliminarUsuarioPosicion;
    
    private int posicion;
    private JLabel textoNumero;
    
    public InterfazUsuario (Usuario usuario){
        this.usuario = usuario;
        inicializarComponentes();
    
    }
    public void inicializarComponentes(){
        
        
        defaultImagen = new ImageIcon ("usuario.png");
        defaultPosicion = new ImageIcon ("usuarioPosicion.png");
        eliminarUsuarioImagen = new ImageIcon ("usuarioEliminar.png");
        eliminarUsuarioPosicion = new ImageIcon ("usuarioPosicionEliminar.png");
        
        imagenUsuario = Configuracion.imagen(defaultImagen, 50, 0, 603, 40);
        imagenPosicion = Configuracion.imagen(defaultPosicion, 0, 1, 40, 37);
        
        imagenPosicion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        colorDefault = new Color (118,113,113);
        colorContraste = new Color (59,56,56);
        
        
        
        
        textoNumero = Configuracion.texto(Integer.toString(posicion), 0 , 0, 40, 37, 20, colorDefault, SwingConstants.CENTER);
        nombre = Configuracion.texto( usuario.getNombre(), 37, 10, 100, 20, 15, colorDefault, SwingConstants.LEFT);
        correo = Configuracion.texto( usuario.getCorreo(), 195, 10, 200, 20, 15, colorDefault, SwingConstants.CENTER);
        rango = Configuracion.texto( usuario.getRango(), 475, 10, 100, 20, 15, colorDefault, SwingConstants.CENTER);
        
        
        
        imagenUsuario.add(rango);
        imagenUsuario.add(correo);
        imagenUsuario.add(nombre);
        
        imagenPosicion.add(textoNumero);
        
        this.add(imagenPosicion);
        this.add(imagenUsuario);
        
    }

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
     * Definir el color del texto 
     * @param color Color del texto
     */
    public void definirColorTexto (Color color){
        nombre.setForeground(color);
        correo.setForeground(color);
        rango.setForeground(color);
    }
    public void definirPosicion (int posicionVertical){
        this.setBounds(5, posicionVertical, 693, 40);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JLabel getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(JLabel imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public JLabel getImagenPosicion() {
        return imagenPosicion;
    }

    public void setImagenPosicion(JLabel imagenPosicion) {
        this.imagenPosicion = imagenPosicion;
    }

    public Color getColorDefault() {
        return colorDefault;
    }

    public void setColorDefault(Color colorDefault) {
        this.colorDefault = colorDefault;
    }

    public Color getColorContraste() {
        return colorContraste;
    }

    public void setColorContraste(Color colorContraste) {
        this.colorContraste = colorContraste;
    }

    public JLabel getNombre() {
        return nombre;
    }

    public void setNombre(JLabel nombre) {
        this.nombre = nombre;
    }

    public JLabel getCorreo() {
        return correo;
    }

    public void setCorreo(JLabel correo) {
        this.correo = correo;
    }

    public JLabel getRango() {
        return rango;
    }

    public void setRango(JLabel rango) {
        this.rango = rango;
    }

    public ImageIcon getDefaultImagen() {
        return defaultImagen;
    }

    public void setDefaultImagen(ImageIcon defaultImagen) {
        this.defaultImagen = defaultImagen;
    }

    public ImageIcon getDefaultPosicion() {
        return defaultPosicion;
    }

    public void setDefaultPosicion(ImageIcon defaultPosicion) {
        this.defaultPosicion = defaultPosicion;
    }

    public ImageIcon getEliminarUsuarioImagen() {
        return eliminarUsuarioImagen;
    }

    public void setEliminarUsuarioImagen(ImageIcon eliminarUsuarioImagen) {
        this.eliminarUsuarioImagen = eliminarUsuarioImagen;
    }

    public ImageIcon getEliminarUsuarioPosicion() {
        return eliminarUsuarioPosicion;
    }

    public void setEliminarUsuarioPosicion(ImageIcon eliminarUsuarioPosicion) {
        this.eliminarUsuarioPosicion = eliminarUsuarioPosicion;
    }

    public JLabel getTextoNumero() {
        return textoNumero;
    }

    public void setTextoNumero(JLabel textoNumero) {
        this.textoNumero = textoNumero;
    }
    
}
