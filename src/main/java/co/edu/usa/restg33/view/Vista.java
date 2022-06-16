/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import co.edu.usa.restg33.model.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author kevin
 */
public class Vista extends JFrame{
    
    /**
     * Tabla de los productos
     */
    private Tabla tablaProducto;
    /**
     * Boton agregar
     */
    private JButton JB_Agregar;
    /**
     * Boton Actualizar
     */
    private JButton JB_Actualizar;
    /**
     * Boton Informe
     */
    private JButton JB_Informe;
    /**
     * Ventana para agregar un producto
     */
    private InsertarDatos ventanaInserccion;
    /**
     * Ventana para actualizar un producto
     */
    private InsertarDatos ventanaActualizar;
    
    private Usuario usuario;
    
    private JButton registrarUsuarios;
    private JButton registro;
    private JButton botonBuscar;
    private JTextField JT_Buscar;
    private JLabel buscar;
    private JButton atras;
    /**
     * Constructor que inicializa los componentes
     */
    public Vista (){
        
        // se define el tamaño de la ventana
        setSize (1016, 740);
        // Se define la operacion cuando se cierra la ventana (terminar la ejecucion)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // se define le titulo
        setTitle ("INVENTARIO");
        // se define su localizacion (centro)
        setLocationRelativeTo (null);
        
        
        // se crea el metodo donde se inicializaran los componentes 
        panelPrincipal ();
    }
    
    /**
     * Panel principal e inicializador componentes
     */
    private void panelPrincipal(){
         
        // Creacion de panel pricipal
        JPanel panel = new JPanel ();  
        // Se quita el layout 
        panel.setLayout(null);  
        // Se define el color
        panel.setBackground(new Color (13,13,13)); 
        // Añadir panel
        this.getContentPane().add(panel);  
        
        
        tablaProducto = new Tabla();
        ventanaInserccion = new InsertarDatos ();
        ventanaActualizar = new InsertarDatos ();
        
        JScrollPane scroll = new JScrollPane (tablaProducto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Se define su tamaño
        scroll.setBounds(50, 140, 916, 476);
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
        
        JLabel informacion = Configuracion.imagen("informacion.png", 50, 80, 888, 46);
        informacion.add(Configuracion.texto("#     ", 45, 0, 150, 46, 20, new Color (175,175,175), SwingConstants.LEFT));
        informacion.add(Configuracion.texto("Nombre                      |",150, 0, 200, 46, 15, new Color (175,175,175), SwingConstants.LEFT));
        informacion.add(Configuracion.texto("Precio                      |", 360, 0, 150, 46, 15, new Color (175,175,175), SwingConstants.LEFT));
        informacion.add(Configuracion.texto("Inventario                  |", 560, 0, 150, 46, 15, new Color (175,175,175), SwingConstants.LEFT));
        informacion.add(Configuracion.texto("Total       ", 760, 0, 150, 46, 15, new Color (175,175,175), SwingConstants.LEFT));
        
        
        // Botones 
        
        JB_Agregar = Configuracion.boton("agregar.png", "agregarSeleccionado.png", "agregarOprimido.png", 50, 636, 144, 38);
        JB_Agregar.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventanaInserccion.setVisible(true);
            }
        });
        
        JB_Actualizar = Configuracion.boton("actualizar.png", "actualizarSeleccionado.png", "actualizarOprimido.png", 210, 636, 144, 38);
        JB_Informe = Configuracion.boton("informe.png", "informeSeleccionado.png", "informeOprimido.png", 792, 636, 144, 38);
        
        buscar = Configuracion.imagen("buscar.png", 319, 30, 619, 39);
        botonBuscar = Configuracion.boton("botonBuscar.png", "botonBuscar.png", "botonBuscar.png", 555, 0, 62, 39);
        JT_Buscar = Configuracion.cajaTexto(10, 2, 530, 35, new Color (38,38,38), new Color (118, 113, 113));
        
        ActionListener accionBuscar = new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buscar (ae);
            }
        };
        botonBuscar.addActionListener(accionBuscar);
        
        registrarUsuarios =Configuracion.boton("RegistrarIcon.png", "RegistrarIconSeleccionado.png", "RegistrarIconOprimido.png", 255, 32, 47, 36);
        registro =Configuracion.boton("registro_1.png", "registroSeleccionado.png", "registroOprimido.png", 200, 32, 45, 36);
        atras = Configuracion.boton("atras.png", "atrasSeleccionado.png", "atrasOprimido.png", 50, 30, 47, 36);
        
        buscar.add(JT_Buscar);
        buscar.add(botonBuscar);
        panel.add(buscar);
        panel.add(atras);
        panel.add(registro);
        panel.add(registrarUsuarios);
        panel.add(JB_Informe);
        panel.add(JB_Actualizar);
        panel.add(JB_Agregar);
        panel.add(informacion);
        panel.add(scroll);
        
        
        
    }

    public void buscar (ActionEvent ae){
        
        if (JT_Buscar.getText().isEmpty()) {
            tablaProducto.buscarProducto(null);
        }else{
            tablaProducto.buscarProducto(JT_Buscar.getText());
        }
    }
    /**
     * 
     * @return Retorna la tabla de los productos
     */
    public Tabla getTablaProducto() {
        return tablaProducto;
    }

    /**
     * Define la tabla de los productos
     * @param tablaProducto Tabla de los productos
     */
    public void setTablaProducto(Tabla tablaProducto) {
        this.tablaProducto = tablaProducto;
    }

    /**
     * 
     * @return Retoena el boton agregar
     */
    public JButton getJB_Agregar() {
        return JB_Agregar;
    }

    /**
     * Define el boton agregar
     * @param JB_Agregar Boton agregar
     */
    public void setJB_Agregar(JButton JB_Agregar) {
        this.JB_Agregar = JB_Agregar;
    }
    
    /**
     * 
     * @return Retorna el boton actualizar
     */
    public JButton getJB_Actualizar() {
        return JB_Actualizar;
    }
    
    /**
     * Define el boton actualizar
     * @param JB_Actualizar Boton actualizar
     */
    public void setJB_Actualizar(JButton JB_Actualizar) {
        this.JB_Actualizar = JB_Actualizar;
    }
    
    /**
     * 
     * @return Retorna el boton informe
     */
    public JButton getJB_Informe() {
        return JB_Informe;
    }

    /**
     * Define el boton informe
     * @param JB_Informe Boton informe
     */
    public void setJB_Informe(JButton JB_Informe) {
        this.JB_Informe = JB_Informe;
    }

    /**
     * 
     * @return Retorna la ventana par agregar productos
     */
    public InsertarDatos getVentanaInserccion() {
        return ventanaInserccion;
    }

    /**
     * Define la ventana
     * @param ventanaInserccion Ventana para ingresar productos
     */
    public void setVentanaInserccion(InsertarDatos ventanaInserccion) {
        this.ventanaInserccion = ventanaInserccion;
    }

    /**
     * 
     * @return Retorna la ventana para actualizar productos
     */
    public InsertarDatos getVentanaActualizar() {
        return ventanaActualizar;
    }

    /**
     * Definir la ventana para actualizar productos
     * @param ventanaActualizar Ventana para actualizar productos
     */
    public void setVentanaActualizar(InsertarDatos ventanaActualizar) {
        this.ventanaActualizar = ventanaActualizar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JButton getRegistrarUsuarios() {
        return registrarUsuarios;
    }

    public void setRegistrarUsuarios(JButton registrarUsuarios) {
        this.registrarUsuarios = registrarUsuarios;
    }

    public JButton getAtras() {
        return atras;
    }

    public void setAtras(JButton atras) {
        this.atras = atras;
    }

    public JButton getRegistro() {
        return registro;
    }

    public void setRegistro(JButton registro) {
        this.registro = registro;
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public void setBotonBuscar(JButton botonBuscar) {
        this.botonBuscar = botonBuscar;
    }

    public JTextField getJT_Buscar() {
        return JT_Buscar;
    }

    public void setJT_Buscar(JTextField JT_Buscar) {
        this.JT_Buscar = JT_Buscar;
    }

    public JLabel getBuscar() {
        return buscar;
    }

    public void setBuscar(JLabel buscar) {
        this.buscar = buscar;
    }
    
    
}
