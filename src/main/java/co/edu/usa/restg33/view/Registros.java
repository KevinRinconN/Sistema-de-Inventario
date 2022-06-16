/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author kevin
 */
public class Registros extends JFrame{
    
    
    private JButton botonAtras;
    private TablaRegistros tablaRegistros;
    
    public Registros (){
         // se define el tamaño de la ventana
        setSize (1016, 680);
        // Se define la operacion cuando se cierra la ventana (terminar la ejecucion)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // se define le titulo
        setTitle ("Registros");
        // se define su localizacion (centro)
        setLocationRelativeTo (null);
        
        
        // se crea el metodo donde se inicializaran los componentes 
        panelPrincipal ();
        
    }
    
    public void panelPrincipal (){
         
        // Creacion de panel pricipal
        JPanel panel = new JPanel ();  
        // Se quita el layout 
        panel.setLayout(null);  
        // Se define el color
        panel.setBackground(new Color (13,13,13)); 
        // Añadir panel
        this.getContentPane().add(panel);  
        
        tablaRegistros = new TablaRegistros ();
        
        JScrollPane scroll = new JScrollPane (tablaRegistros,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Se define su tamaño
        scroll.setBounds(50, 80, 916, 476);
        // Se quita los bordes
        scroll.setBorder(null);
        scroll.setOpaque(false);
        
        scroll.getViewport().setBackground(new Color (13,13,13));
        scroll.getVerticalScrollBar().setBackground(new Color (20,20,20));
    
        scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
            this.thumbColor = new Color (35,35,35);
            
            }
        });
        
        JLabel textoHistorial = Configuracion.texto("Historial", 55, 30, 526, 40, 30, new Color (255,192,0), SwingConstants.LEFT, "Aharoni");
        botonAtras = Configuracion.boton("atras.png", "atrasSeleccionado.png", "atrasOprimido.png", 919, 30, 47, 36);
        
        panel.add(botonAtras);
        panel.add(textoHistorial);
        panel.add(scroll);
        
        
    }

    public JButton getBotonAtras() {
        return botonAtras;
    }

    public void setBotonAtras(JButton botonAtras) {
        this.botonAtras = botonAtras;
    }

    public TablaRegistros getTablaRegistros() {
        return tablaRegistros;
    }

    public void setTablaRegistros(TablaRegistros tablaRegistros) {
        this.tablaRegistros = tablaRegistros;
    }

    
    
}
