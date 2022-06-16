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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author kevin
 */
public class Login extends JFrame{
    
    private JButton botonLogin;
    private JTextField ingresarNombre;
    private JTextField ingresarContraseña;
    
    /**
     * Constructor que inicializa los componentes
     */
    public Login (){
        
        // se define el tamaño de la ventana
        setSize (1016, 600);
        // Se define la operacion cuando se cierra la ventana (terminar la ejecucion)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        
        //login
        JLabel panelLogin = Configuracion.imagen("login.png", 30, 30, 526, 490);
        JLabel loginText = Configuracion.texto("Login", 0, 30, 526, 40, 30, new Color (255,192,0), SwingConstants.CENTER, "Aharoni");
        JLabel nombreText = Configuracion.texto("Nombre", 60, 100, 300, 30, 20,new Color (191,191,191), SwingConstants.LEFT, "Montserrat");
        ingresarNombre = Configuracion.cajaTexto(60, 140, 406, 40, new Color (38,38,38), new Color (191,191,191));
        JLabel contraseñaText = Configuracion.texto("Contraseña", 60, 210, 300, 30, 20,new Color (191,191,191), SwingConstants.LEFT, "Montserrat");
        ingresarContraseña = Configuracion.cajaTexto(60, 250, 406, 40, new Color (38,38,38), new Color (191,191,191));
        botonLogin = Configuracion.boton("loginBoton.png", "loginBotonSeleccionado.png", "loginBotonOprimido.png", 60 , 350, 414, 51);
        
        
        
        panelLogin.add(botonLogin);
        panelLogin.add(ingresarContraseña);
        panelLogin.add(contraseñaText);
        panelLogin.add(ingresarNombre);
        panelLogin.add(nombreText);
        panelLogin.add(loginText);
        panel.add(Configuracion.imagen("pera.png", 580, 60, 374, 375));
        panel.add(panelLogin);
        
        
        
    }
    public void borrarTexto (){
        ingresarNombre.setText("");
        ingresarContraseña.setText("");
    }
    public JButton getBotonLogin() {
        return botonLogin;
    }

    public void setBotonLogin(JButton botonLogin) {
        this.botonLogin = botonLogin;
    }

    public JTextField getIngresarNombre() {
        return ingresarNombre;
    }

    public void setIngresarNombre(JTextField ingresarNombre) {
        this.ingresarNombre = ingresarNombre;
    }

    public JTextField getIngresarContraseña() {
        return ingresarContraseña;
    }

    public void setIngresarContraseña(JTextField ingresarContraseña) {
        this.ingresarContraseña = ingresarContraseña;
    }
    
    
}
