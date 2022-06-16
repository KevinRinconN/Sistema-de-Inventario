/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.view;

import co.edu.usa.restg33.model.RegistroProducto;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author kevin
 */
public class InterfazRegistro extends JLabel {

    private RegistroProducto registro;
    private JLabel contenedorRegistro;
    private JLabel contenedorFecha;

    /**
     * Color por defecto del texto en los JLabels
     */
    private Color colorDefault;
    /**
     * Color del texto cuando se usen la imagenes de eliminar y actualizar
     */
    private Color colorContraste;

    private JLabel codigo;
    private JLabel nombreProducto;
    private JLabel nombreUsuario;
    private JLabel precio;
    private JLabel inventario;
    private JLabel accion;
    private JLabel fecha;
    private JLabel hora;

    private ImageIcon imagenAgregar;
    private ImageIcon imagenActualizar;
    private ImageIcon imagenEliminar;
    private ImageIcon fechaHora;

    public InterfazRegistro(RegistroProducto registro) {
        this.registro = registro;
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        imagenAgregar = new ImageIcon("registroAgregar.png");
        imagenActualizar = new ImageIcon("registroActualizar.png");
        imagenEliminar = new ImageIcon("registroEliminar.png");
        fechaHora = new ImageIcon("fecha.png");

        

        contenedorFecha = Configuracion.imagen(fechaHora, 0, 0, 102, 87);

        colorDefault = new Color(118, 113, 113);
        colorContraste = new Color(59, 56, 56);

        nombreUsuario = Configuracion.texto(registro.getUsuario().getNombre(), 0, 10, 240, 25, 15, colorDefault, SwingConstants.CENTER);
        accion = Configuracion.texto(registro.getAccion(), 248, 10, 248, 20, 15, colorContraste, SwingConstants.CENTER);
        codigo = Configuracion.texto("Codigo: " + Integer.toString(registro.getCodigo()), 500, 10, 248, 25, 15, colorContraste, SwingConstants.CENTER);

        hora = Configuracion.texto(registro.getHora(), 0, 12, 102, 20, 15, colorDefault, SwingConstants.CENTER);
        fecha = Configuracion.texto(registro.getFecha(), 0, 55, 102, 20, 13, colorDefault, SwingConstants.CENTER);
        
        
        
        if (registro.getAccion().equals("Agregar")) {
            contenedorRegistro = Configuracion.imagen(imagenAgregar, 110, 0, 746, 87);
        } 
        if (registro.getAccion().equals("Eliminar")) {
            contenedorRegistro = Configuracion.imagen(imagenEliminar, 110, 0, 746, 87);
        }
        if (registro.getAccion().equals("Actualizar")) {
            contenedorRegistro = Configuracion.imagen(imagenActualizar, 110, 0, 746, 87);
            if (registro.getNombre() == null) {
                nombreProducto = Configuracion.texto("Nombre: Sin modificar", 0, 44, 240, 37, 15, colorDefault, SwingConstants.CENTER);
            }else{
                nombreProducto = Configuracion.texto("Nombre: " + registro.getNombre(), 0, 44, 240, 37, 15, colorDefault, SwingConstants.CENTER);
            }
            if (registro.getPrecio() == null) {
                precio = Configuracion.texto("Precio: Sin modificar", 248, 44, 248, 37, 15, colorDefault, SwingConstants.CENTER);
            }else{
                precio = Configuracion.texto("Precio: " + Double.toString(registro.getPrecio()), 248, 44, 248, 37, 15, colorDefault, SwingConstants.CENTER);
            }
            if (registro.getInventario() == null) {
                inventario = Configuracion.texto("Inventario: Sin modificar", 500, 44, 248, 37, 15, colorDefault, SwingConstants.CENTER);
            }else{
                inventario = Configuracion.texto("Inventario: " + Integer.toString(registro.getInventario()), 500, 44, 248, 37, 15, colorDefault, SwingConstants.CENTER);
            }

        }else{
            nombreProducto = Configuracion.texto("Nombre: " + registro.getNombre(), 0, 44, 240, 37, 15, colorDefault, SwingConstants.CENTER);
            precio = Configuracion.texto("Precio: " + Double.toString(registro.getPrecio()), 248, 44, 248, 37, 15, colorDefault, SwingConstants.CENTER);
            inventario = Configuracion.texto("Inventario: " + Integer.toString(registro.getInventario()), 500, 44, 248, 37, 15, colorDefault, SwingConstants.CENTER);
        }
        
        contenedorRegistro.add(codigo);
        contenedorRegistro.add(nombreUsuario);
        contenedorRegistro.add(precio);
        contenedorRegistro.add(inventario);
        contenedorRegistro.add(accion);
        contenedorRegistro.add(nombreProducto);

        contenedorFecha.add(fecha);
        contenedorFecha.add(hora);

        this.add(contenedorRegistro);
        this.add(contenedorFecha);

    }

    public void definirPosicion(int posicionVertical) {
        this.setBounds(5, posicionVertical, 860, 87);
    }

}
