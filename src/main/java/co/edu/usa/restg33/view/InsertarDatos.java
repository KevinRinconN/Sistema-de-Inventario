/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * Ventana para insertar datos, tales como el nombre, precio e inventario del producto
 * @author Kevin Rincon
 */
public class InsertarDatos extends JFrame {
    
    /**
     * Boton agregar los datos
     */
    private JButton JB_Agregar;
    /**
     * Boton de cancelar 
     */
    private JButton JB_Cancelar;
    /**
     * JTextField para el nombre del producto
     */
    private JTextField JTNombre;
    /**
     * JTextFielf para el precio del producto
     */
    private JTextField JTPrecio;
    /**
     * JTextField para el inventario del producto
     */
    private JTextField JTInventario;
    
    
    
    /**
     * constructor para inicializar con los elementos necesarios
     * @param baseDatos Base de datos donde estan alojados los productos
     * @param panelAgregar Panel donde contiene los prodctos
     * @param opcion Accion a realizar (AGREGAR O ACTUALIZAR)
     */
    public InsertarDatos (){
        // Se define el tamaño de la ventana
        setSize (459, 410);
        // se define su operacion al cerrar
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /// Se define el titulo
        setTitle ("Insertar Datos");
        // se define la localizacion de la ventana (Centro)
        setLocationRelativeTo (null);
        
        // Se instancia la funcion para incializar los elementos 
        inicializarComponentes ();
    }
    
    /**
     * Inicializador de componentes
     * @param baseDatos Base de datos donde se alojan los productos
     * @param panelAgregar Panel donde se añadieron los productos
     * @param opcion Accion a realizar (AGREGAR, ACTUALIZAR)
     */
    public void inicializarComponentes (){
        
        // Creacion de panel pricipal
        JPanel panel = new JPanel ();  
        // Se quita el layout 
        panel.setLayout(null);  
        // Se define el color
        panel.setBackground(new Color (13,13,13)); 
        // Añadir panel
        this.getContentPane().add(panel);  
        
        
        // Se añade la imagen del encabezado
        panel.add(Configuracion.imagen("insertar.png", 10, 10, 439, 30));
        
        Color colorTexto = new Color (175,171,171);
        Color color = new Color (38,38,38);
        // Se añade el texto nombre
        panel.add(Configuracion.texto("Nombre ", 60, 55, 100, 20, 20,colorTexto));
        // Se añade la caja de texto del nombre
        JTNombre = Configuracion.cajaTexto(60,85, 320, 30, color, colorTexto);
        
        
        // Se añade el texto de precio
        panel.add(Configuracion.texto("Precio ", 60, 130, 100, 20, 20,colorTexto));
        // Se añade la caja de texto de precio
        JTPrecio = Configuracion.cajaTexto(60, 165, 320, 30, color, colorTexto);
        
        // Se añade el texto de inventario
        panel.add(Configuracion.texto("Inventario ", 60, 210, 150, 20, 20, colorTexto));
        // Se añade la caja de texto de inventario
        JTInventario = Configuracion.cajaTexto(60, 240, 320, 30, color, colorTexto);
        
        // Se crea el boton para agregar o actualizar los productos
        JB_Agregar = Configuracion.boton("aceptar.png", "aceptarSeleccionado.png", "aceptarOprimido.png", 60, 300, 144, 37);
        
        
        
        // Se crea el boton de cancelar 
        JB_Cancelar = Configuracion.boton("cancelar.png", "cancelarSeleccionado.png", "cancelarOprimido.png", 240, 300, 144, 38);
        // Se añade su accion
        JB_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // se oculta la ventana
                definirVisibilidad (false);
                
            }
        });
        
        // se añade el boton agregar al panel principal
        panel.add(JB_Agregar);
        // se añade el boton cancelar al panel principal
        panel.add(JB_Cancelar);
        // se añade la caja de texto inventario al panel principal
        panel.add(JTInventario);
        // se añade la caja de texto nombre al panel principal
        panel.add(JTNombre);
        // se añade la caja de texto precio al panel principal
        panel.add(JTPrecio);
    }
    
    /**
     * Borra el texto de todos los JTextField
     */
    public void borrarTexto (){
        JTNombre.setText("");
        JTPrecio.setText("");
        JTInventario.setText("");
    }
    
    /**
     * Define la visibilidad del panel
     * @param visible Boolean 
     */
    public void definirVisibilidad (boolean visible){
        this.setVisible(visible);
    }
    
    /**
     * 
     * @return Retorna el boton agregar
     */
    public JButton getJB_Agregar() {
        return JB_Agregar;
    }
    
    /**
     * Define el boton
     * @param JB_Agregar Boton agregar
     */
    public void setJB_Agregar(JButton JB_Agregar) {
        this.JB_Agregar = JB_Agregar;
    }
    
    /**
     * 
     * @return Retorna el boton cancelar
     */
    public JButton getJB_Cancelar() {
        return JB_Cancelar;
    }
    
    /**
     * Define el boton
     * @param JB_Cancelar Boton cancelar
     */
    public void setJB_Cancelar(JButton JB_Cancelar) {
        this.JB_Cancelar = JB_Cancelar;
    }
    
    /**
     * 
     * @return Retorna el JTextField del nombre
     */
    public JTextField getJTNombre() {
        return JTNombre;
    }
    
    /**
     * Define el JTextField
     * @param JTNombre JTextField del nombre
     */
    public void setJTNombre(JTextField JTNombre) {
        this.JTNombre = JTNombre;
    }
    
    /**
     * 
     * @return Retorna el JTextField del precio
     */
    public JTextField getJTPrecio() {
        return JTPrecio;
    }
    
    /**
     * Define el JTextField
     * @param JTPrecio JTextField del precio
     */
    public void setJTPrecio(JTextField JTPrecio) {
        this.JTPrecio = JTPrecio;
    }
    
    /**
     * 
     * @return Retorna el JTextField del inventario
     */
    public JTextField getJTInventario() {
        return JTInventario;
    }
    
    /**
     * Define el JTextField 
     * @param JTInventario JTextField del inventario
     */
    public void setJTInventario(JTextField JTInventario) {
        this.JTInventario = JTInventario;
    }
    
    
}
