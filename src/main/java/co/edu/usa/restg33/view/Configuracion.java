/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Modificaciones de componentes del java Swing
 * @author Kevin Rincon
 */
class Configuracion {
    
    /**
     * Boton con posicion
     * @param imagen Imagen del boton
     * @param imagenSeleccionada Imagen del boton cuando es seleccionado
     * @param imagenOprimida Imagen del boton cuando lo oprimen 
     * @param posicionHorizontal Posicion horizontal del boton
     * @param posicionVertical Posicion Vertical del boton
     * @param tamañoAncho Ancho del boton
     * @param tamañoAlto Alto del boton
     * @return Retorna un boton con imagen, posicion y tamaño modificado
     */
    public static JButton boton (String imagen, String imagenSeleccionada, String imagenOprimida, int posicionHorizontal, int posicionVertical, int tamañoAncho, int tamañoAlto){
        
        JButton boton = new JButton ();
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setRolloverIcon(new ImageIcon (imagenSeleccionada));
        boton.setPressedIcon(new ImageIcon (imagenOprimida));
        boton.setCursor(new Cursor (Cursor.HAND_CURSOR));
        boton.setIcon(new ImageIcon(imagen));
        boton.setBounds(posicionHorizontal, posicionVertical, tamañoAncho, tamañoAlto);
        
        return boton;
    }
    
    /**
     * Boton sin posicion 
     * @param imagen Imagen del boton
     * @param imagenSeleccionada Imagen del boton seleccionado
     * @param imagenOprimida Imagen del boton oprimido 
     * @param tamañoAncho Ancho del boton
     * @param tamañoAlto Alto del boton
     * @return Retorna un boton con imagen y tamaño modificado
     */
    public static JButton boton (String imagen, String imagenSeleccionada, String imagenOprimida, int tamañoAncho, int tamañoAlto){
        
        JButton boton = new JButton ();
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setRolloverIcon(new ImageIcon (imagenSeleccionada));
        boton.setPressedIcon(new ImageIcon (imagenOprimida));
        boton.setCursor(new Cursor (Cursor.HAND_CURSOR));
        boton.setIcon(new ImageIcon(imagen));
        boton.setSize(tamañoAncho, tamañoAlto);
        
        return boton;
    }
    
    /**
     * Imagen dentro de un label
     * @param png Imagen del label
     * @param posicionHorizontal Posicion horizontal del label
     * @param posicionVertical Posicion vertical del label
     * @param tamañoAncho ancho del label
     * @param tamañoAlto alto del label
     * @return Retorna un label con imagen, posicion y tamaño
     */
    public static JLabel imagen (String png, int posicionHorizontal, int posicionVertical, int tamañoAncho, int tamañoAlto){
        
        JLabel imagenDisponible = new JLabel ();
        ImageIcon image = new ImageIcon (png);
        imagenDisponible.setBounds(posicionHorizontal, posicionVertical, tamañoAncho, tamañoAlto);
        imagenDisponible.setIcon(new ImageIcon (image.getImage().getScaledInstance(tamañoAncho, tamañoAlto, Image.SCALE_SMOOTH)));
        
        return imagenDisponible;
    }
    
    /**
     * Imagen dentro de un label
     * @param png Imagen del label
     * @param posicionHorizontal Posicion horizontal del label
     * @param posicionVertical Posicion vertical del label
     * @param tamañoAncho ancho del label
     * @param tamañoAlto alto del label
     * @return Retorna un label con imagen, posicion y tamaño
     */
    public static JLabel imagen (ImageIcon image, int posicionHorizontal, int posicionVertical, int tamañoAncho, int tamañoAlto){
        
        JLabel imagenDisponible = new JLabel ();
        imagenDisponible.setBounds(posicionHorizontal, posicionVertical, tamañoAncho, tamañoAlto);
        imagenDisponible.setIcon(new ImageIcon (image.getImage().getScaledInstance(tamañoAncho, tamañoAlto, Image.SCALE_SMOOTH)));
        
        return imagenDisponible;
    }
    
    
    /**
     * Caja de texto modificada
     * @param posicionHorizontal Posicion horizontal de la caja de texto
     * @param posicionVertical Posicion vertical de la caja de texto 
     * @param tamañoH Ancho de la caja de texto
     * @param tamañoV Alto de la caja de texto
     * @return retorna una caja de texto con posicion y tamaño
     */
    public static JTextField cajaTexto (int posicionHorizontal, int posicionVertical, int tamañoH, int tamañoV){
        
        JTextField cajaTexto = new JTextField ();
        cajaTexto.setBorder(null);
        cajaTexto.setBackground(new Color (221, 221, 221));
        cajaTexto.setBounds(posicionHorizontal, posicionVertical, tamañoH, tamañoV);
        cajaTexto.setForeground(Color.BLACK);
        cajaTexto.setFont(new Font ("",Font.PLAIN,20));
        
        return cajaTexto;
    }
    
    /**
     * Caja de texto modificada
     * @param posicionHorizontal Posicion Horizontal de la caja de texto
     * @param posicionVertical Posicion vertical de la caja de texto
     * @param tamañoH Ancho de la caja de texto
     * @param tamañoV Alto de la caja de texto
     * @param color Color del JLabel
     * @param colorTexto Color del texto
     * @return Retorna una caja de texto con posicion, tamaño, color del backgraund y del texto
     */
    public static JTextField cajaTexto (int posicionHorizontal, int posicionVertical, int tamañoH, int tamañoV, Color color, Color colorTexto){
        
        JTextField cajaTexto = new JTextField ();
        cajaTexto.setBorder(null);
        cajaTexto.setBackground(color);
        cajaTexto.setBounds(posicionHorizontal, posicionVertical, tamañoH, tamañoV);
        cajaTexto.setForeground(colorTexto);
        cajaTexto.setFont(new Font ("Roboto",Font.PLAIN,20));
        
        return cajaTexto;
    }
    /**
     * Texto en un label
     * @param nombre Texto del label
     * @param horizontal Posicion horizontal del label
     * @param vertical posicion vertical del label
     * @param tHorizontal ancho del label
     * @param tVertical alto del label
     * @return Retorna un label con texto
     */
    public static JLabel texto (String nombre, int horizontal, int vertical, int tHorizontal, int tVertical){
        
        JLabel texto = new JLabel (nombre,SwingConstants.CENTER);
        texto.setBounds(horizontal, vertical, tHorizontal, tVertical);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font ("Roboto",Font.BOLD,20));
        
        return texto;
    }
    /**
     * Texto en un JLabel modificando el tamaño de letra
     * @param nombre Texto del JLabel
     * @param horizontal Posicion horizontal del JLabel
     * @param vertical Posicion vertical del JLabel
     * @param tHorizontal Ancho del JLabel
     * @param tVertical Alto del JLabel
     * @param tamaño Tamaño de la letra
     * @return Retorna un JLabel con un texto
     */
    public static JLabel texto (String nombre, int horizontal, int vertical, int tHorizontal, int tVertical, int tamaño, Color color){
        
        JLabel texto = new JLabel (nombre,SwingConstants.LEFT);
        texto.setBounds(horizontal, vertical, tHorizontal, tVertical);
        texto.setForeground(color);
        texto.setFont(new Font ("Roboto",Font.PLAIN,tamaño));
        
        return texto;
    }
    
    
    /**
     * Texto modificado en un JLabel
     * @param nombre Texto del JLabel
     * @param horizontal Posicion horizontal del JLabel
     * @param vertical Posicion vertical de JLabel
     * @param tHorizontal Ancho del JLabel
     * @param tVertical Alto del JLabel
     * @param tamaño Tamaño de la letra
     * @param color Color de la letra
     * @param alineacion Alineacion del texto 
     * @return Retorna un JLabel con un texto
     */
    public static JLabel texto (String nombre, int horizontal, int vertical, int tHorizontal, int tVertical, int tamaño, Color color, int alineacion){
        
        
        JLabel texto = new JLabel (nombre,alineacion);
        texto.setBounds(horizontal, vertical, tHorizontal, tVertical);
        texto.setForeground(color);
        texto.setFont(new Font ("Roboto",Font.PLAIN,tamaño));
        
        return texto;
    }
    
    /**
     * Texto modificado en un JLabel
     * @param nombre Texto del JLabel
     * @param horizontal Posicion horizontal del JLabel
     * @param vertical Posicion vertical de JLabel
     * @param tHorizontal Ancho del JLabel
     * @param tVertical Alto del JLabel
     * @param tamaño Tamaño de la letra
     * @param color Color de la letra
     * @param alineacion Alineacion del texto 
     * @return Retorna un JLabel con un texto
     */
    public static JLabel texto (String nombre, int horizontal, int vertical, int tHorizontal, int tVertical, int tamaño, Color color, int alineacion, String letra){
        
        
        JLabel texto = new JLabel (nombre,alineacion);
        texto.setBounds(horizontal, vertical, tHorizontal, tVertical);
        texto.setForeground(color);
        texto.setFont(new Font (letra,Font.PLAIN,tamaño));
        
        return texto;
    }
}
