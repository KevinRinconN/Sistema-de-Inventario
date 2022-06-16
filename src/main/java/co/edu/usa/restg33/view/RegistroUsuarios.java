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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author kevin
 */
public class RegistroUsuarios extends JFrame {
    
    private JTextField registrarNombre;
    private JTextField registrarCorreo;
    private JTextField registrarContraseña;
    private JButton registrarUsuario;
    private JButton atras;
    private JRadioButton rango;
    private TablaUsuarios tablaUsuarios;
    
    
    public RegistroUsuarios (){
        
        // se define el tamaño de la ventana
        setSize (1240, 730);
        // Se define la operacion cuando se cierra la ventana (terminar la ejecucion)
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // se define le titulo
        setTitle ("INVENTARIO");
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
        
        tablaUsuarios= new TablaUsuarios();
        
        JScrollPane scroll = new JScrollPane (tablaUsuarios,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Se define su tamaño
        scroll.setBounds(500, 160, 690, 450);
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
        
        JLabel panelRegistro = Configuracion.imagen("registro.png", 30, 30, 457, 600);
        JLabel registroText = Configuracion.texto("Registrar Usuarios", 0, 30, 457, 40, 30, new Color (255,192,0), SwingConstants.CENTER, "Aharoni");
        JLabel nombreText = Configuracion.texto("Nombre", 60, 100, 300, 30, 20,new Color (191,191,191), SwingConstants.LEFT, "Montserrat");
        registrarNombre = Configuracion.cajaTexto(60, 140, 337, 40, new Color (38,38,38), new Color (191,191,191));
        JLabel correoText = Configuracion.texto("Correo", 60, 210, 300, 30, 20,new Color (191,191,191), SwingConstants.LEFT, "Montserrat");
        registrarCorreo = Configuracion.cajaTexto(60, 250, 337, 40, new Color (38,38,38), new Color (191,191,191));
        JLabel contraseñaText = Configuracion.texto("Contraseña", 60, 320, 300, 30, 20,new Color (191,191,191), SwingConstants.LEFT, "Montserrat");
        registrarContraseña = Configuracion.cajaTexto(60, 360, 337, 40, new Color (38,38,38), new Color (191,191,191));
        
        registrarUsuario = Configuracion.boton("registrar.png", "registrarSeleccionado.png", "registrarOprimido.png", 60, 500, 331, 51);
        atras = Configuracion.boton("atras.png", "atrasSeleccionado.png", "atrasOprimido.png", 1143, 42, 47, 36);
        
        rango = new JRadioButton ("Administrador", false);
        rango.setBounds(60, 430, 320, 30);
        rango.setBackground(new Color (25,25,25));
        rango.setForeground(new Color (191,191,191));
        
  
        
        panelRegistro.add(registroText);
        panelRegistro.add(nombreText);
        panelRegistro.add(registrarNombre);
        panelRegistro.add(correoText);
        panelRegistro.add(registrarCorreo);
        panelRegistro.add(contraseñaText);
        panelRegistro.add(rango);
        panelRegistro.add(registrarContraseña);
        panelRegistro.add(registrarUsuario);
        
        panel.add(panelRegistro);
        panel.add(Configuracion.texto("Usuarios", 505, 45, 300, 40, 30, new Color (175,171,171), SwingConstants.LEFT, "Aharoni"));
        panel.add(atras);
        panel.add(Configuracion.imagen("informacionUsuario.png", 505, 100, 687 , 55));
        panel.add(scroll);
    }
    
    public void borrarTexto (){
        registrarNombre.setText("");
        registrarCorreo.setText("");
        registrarContraseña.setText("");
    }
    public JTextField getRegistrarNombre() {
        return registrarNombre;
    }

    public void setRegistrarNombre(JTextField registrarNombre) {
        this.registrarNombre = registrarNombre;
    }

    public JTextField getRegistrarCorreo() {
        return registrarCorreo;
    }

    public void setRegistrarCorreo(JTextField registrarCorreo) {
        this.registrarCorreo = registrarCorreo;
    }

    public JTextField getRegistrarContraseña() {
        return registrarContraseña;
    }

    public void setRegistrarContraseña(JTextField registrarContraseña) {
        this.registrarContraseña = registrarContraseña;
    }

    public JButton getRegistrarUsuario() {
        return registrarUsuario;
    }

    public void setRegistrarUsuario(JButton registrarUsuario) {
        this.registrarUsuario = registrarUsuario;
    }

    public JRadioButton getRango() {
        return rango;
    }

    public void setRango(JRadioButton rango) {
        this.rango = rango;
    }

    public TablaUsuarios getTablaUsuarios() {
        return tablaUsuarios;
    }

    public void setTablaUsuarios(TablaUsuarios tablaUsuarios) {
        this.tablaUsuarios = tablaUsuarios;
    }

    public JButton getAtras() {
        return atras;
    }

    public void setAtras(JButton atras) {
        this.atras = atras;
    }
    
}
