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
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class TablaRegistros extends JPanel {
    
    private List<InterfazRegistro> listaRegistros;
    
    /**
    * Imagen del panel
    */
    
     public TablaRegistros (){
        //Se inicicializa la lista
        listaRegistros = new ArrayList<InterfazRegistro> ();
        // Se define el color del panel
        setBackground(new Color (13,13,13));
        // se quita el layout 
        setLayout(null);
        
        
    }
     
    
    
    public void ordenarTabla (){
        int posicionVertical = 10;
        
        Collections.reverse(listaRegistros);
         
        for (InterfazRegistro registro : listaRegistros) {
            
            
            registro.definirPosicion(posicionVertical);
            posicionVertical +=105;
        }
        
        this.setPreferredSize(new Dimension (890,posicionVertical));
        Collections.reverse(listaRegistros);
        this.updateUI();
    }
    
    public void insertarRegistro (InterfazRegistro registro){
        listaRegistros.add(registro);
        this.add(registro);
        ordenarTabla();
    }

    public List<InterfazRegistro> getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(List<InterfazRegistro> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }
    
    
    
}
