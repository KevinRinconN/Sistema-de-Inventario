/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import co.edu.usa.restg33.model.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class TablaUsuarios extends JPanel{
    
    private List<InterfazUsuario> listaUsuarios;
    
    
    public TablaUsuarios (){
        //Se inicicializa la lista
        listaUsuarios = new ArrayList<InterfazUsuario> ();
        // Se define el color del panel
        setBackground(new Color (13,13,13));
        // se quita el layout 
        setLayout(null);
        
        
    }
    
    public void ordenarTabla (){
        int posicionVertical = 10;
        int numeroPosicion = 1;
        
        for (InterfazUsuario usuario : listaUsuarios) {
            
            usuario.setPosicion(numeroPosicion);
            usuario.definirPosicion(posicionVertical);
            posicionVertical +=50;
            numeroPosicion++;
        }
        
        this.setPreferredSize(new Dimension (651,posicionVertical));
        this.updateUI();
    }
    
    public void insertarUsuario (InterfazUsuario usuario){
        listaUsuarios.add(usuario);
        this.add(usuario);
        ordenarTabla();
    }
    
    public boolean verificarExistencia (String nombre){
        
        boolean verificador = false;
        
        for (InterfazUsuario usuario : listaUsuarios) {
            
            if (usuario.getUsuario().getNombre().equals(nombre)) {
                
                verificador = true;
                
            }
            
        }
        return verificador;
    }
   
    public boolean verificarExistenciaCorreo (String correo){
        
        boolean verificador = false;
        
        for (InterfazUsuario usuario : listaUsuarios) {
            
            if (usuario.getUsuario().getCorreo().equals(correo)) {
                
                verificador = true;
                
            }
            
        }
        return verificador;
    }

    public List<InterfazUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<InterfazUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
