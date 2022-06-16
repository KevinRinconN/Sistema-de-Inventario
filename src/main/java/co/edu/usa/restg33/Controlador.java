/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33;

import co.edu.usa.restg33.model.Producto;
import co.edu.usa.restg33.model.RegistroProducto;
import co.edu.usa.restg33.model.Usuario;
import co.edu.usa.restg33.repository.ProductoRepository;
import co.edu.usa.restg33.repository.RegistroProductoRepository;
import co.edu.usa.restg33.repository.UsuarioRepository;
import co.edu.usa.restg33.view.InterfazProducto;
import co.edu.usa.restg33.view.InterfazRegistro;
import co.edu.usa.restg33.view.InterfazUsuario;
import co.edu.usa.restg33.view.Login;
import co.edu.usa.restg33.view.RegistroUsuarios;
import co.edu.usa.restg33.view.Registros;
import co.edu.usa.restg33.view.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador
 *
 * @author Kevin Rincon
 */
public class Controlador implements ActionListener {

    /**
     * Repositorio de la base de datos
     */
    ProductoRepository repositorio;
    RegistroProductoRepository registroProducto;
    UsuarioRepository usuarioRepositorio;
    /**
     * JFrame principal
     */
    Vista vista;
    Login login;
    RegistroUsuarios registro;
    Registros historial;
    

    /**
     * Constructor vacio
     */
    public Controlador() {
    }

    /**
     * Constructor para inicializar componentes
     *
     * @param repositorio Repositorio
     * @param vista JFrame vista
     */
    public Controlador(ProductoRepository repositorio, UsuarioRepository usuarioRepositorio,RegistroProductoRepository registroProducto, Vista vista, RegistroUsuarios registro, Login login) {
        super();
        historial = new Registros ();
        this.repositorio = repositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.registro = registro;
        this.login = login;
        this.registroProducto = registroProducto;
        this.vista = vista;
        
        agregarEventos();
        listarProducto();
        listarUsuarios();
        listarRegistros();
        login.setVisible(true);
        
    }

    /**
     * Agrega los ActionListener a cada boton
     */
    private void agregarEventos() {
        
        vista.getVentanaInserccion().getJB_Agregar().addActionListener(this);
        vista.getVentanaActualizar().getJB_Agregar().addActionListener(this);
        vista.getJB_Actualizar().addActionListener(this);
        vista.getJB_Informe().addActionListener(this);
        vista.getRegistrarUsuarios().addActionListener(this);
        vista.getAtras().addActionListener(this);
        registro.getRegistrarUsuario().addActionListener(this);
        registro.getAtras().addActionListener(this);
        login.getBotonLogin().addActionListener(this);
        vista.getRegistro().addActionListener(this);
        historial.getBotonAtras().addActionListener(this);

    }

    /**
     * definir cada evento para cada boton
     *
     * @param ae ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getVentanaInserccion().getJB_Agregar()) {
            agregarProducto(ae);
        }
        if (ae.getSource() == vista.getVentanaActualizar().getJB_Agregar()) {
            actualizarProducto(ae);
        }
        if (ae.getSource() == vista.getJB_Actualizar()) {
            abrirVentanaActualizar(ae);
        }
        if (ae.getSource() == vista.getJB_Informe()) {
            informe(ae);
        }
        if (ae.getSource() == registro.getRegistrarUsuario()) {
            registrarUsuario(ae);
        }
        if (ae.getSource() == login.getBotonLogin()) {
            login(ae);
        }

        if (ae.getSource() == vista.getRegistrarUsuarios()) {
            abrirRegistroUsuario(ae);
        }
        if (ae.getSource() == vista.getRegistro()) {
            abrirHistorial(ae);
        }
        if (ae.getSource() == vista.getAtras()) {
            atrasVista(ae);
        }
        if (ae.getSource() == registro.getAtras()) {
            atrasRegistro(ae);
        }
        if (ae.getSource() == historial.getBotonAtras()) {
            atrasHistorial(ae);
        }
        
    }
    
    public void atrasHistorial (ActionEvent ae){
        historial.setVisible(false);
        vista.setVisible(true);
    }
    
    public void abrirHistorial (ActionEvent ae){
        vista.setVisible(false);
        historial.getTablaRegistros().ordenarTabla();
        historial.setVisible(true);
        
    }
    
    /**
     *
     * *******************************************************************************************************************************************************
     * ----------------------------------------------------------------------------Login--------------------------------------------------------------
     * *******************************************************************************************************************************************************
     *
     */
    public void login(ActionEvent ae) {

        try {
            if (!login.getIngresarContraseña().getText().isEmpty()
                    && !login.getIngresarNombre().getText().isEmpty()) {

                boolean contraseña = false;
                boolean usuarioC = false;
                for (Usuario usuario : usuarioRepositorio.getAll()) {
                    if (login.getIngresarNombre().getText().equals(usuario.getNombre())) {
                        if (usuario.getContraseña().equals(login.getIngresarContraseña().getText())) {

                            vista.setUsuario(usuario);
                            vista.setVisible(true);
                            login.borrarTexto();
                            login.setVisible(false);
                            contraseña = true;

                        }
                        usuarioC = true;
                    }

                }
                
                    
                if (!usuarioC) {
                    JOptionPane.showMessageDialog(vista.getVentanaInserccion(), "No existe el usuario en la base de datos\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!contraseña) {
                    JOptionPane.showMessageDialog(vista.getVentanaInserccion(), "Contraseña Incorrecta\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vista.getVentanaInserccion(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception sinDatos) {
            JOptionPane.showMessageDialog(vista.getVentanaInserccion(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n" + sinDatos.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     *
     * *******************************************************************************************************************************************************
     * ----------------------------------------------------------------------------Vista--------------------------------------------------------------
     * *******************************************************************************************************************************************************
     *
     */
    public void abrirRegistroUsuario(ActionEvent ae) {
        if (vista.getUsuario().getRango().equals("Administrador")) {
            vista.setVisible(false);
            registro.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(vista, "Solo un usuario con rango de administrador puede acceder a esta funcion\n", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     *
     * @param ae
     */
    public void atrasVista(ActionEvent ae) {
        vista.setVisible(false);
        login.setVisible(true);
    }

    /**
     * Agregar productos
     *
     * @param ae ActionEvent
     */
    public void agregarProducto(ActionEvent ae) {
        
        try{
            if (!vista.getVentanaInserccion().getJTNombre().getText().isEmpty()
                    && !vista.getVentanaInserccion().getJTPrecio().getText().isEmpty()
                    && !vista.getVentanaInserccion().getJTInventario().getText().isEmpty()) {

                String nombre = vista.getVentanaInserccion().getJTNombre().getText();
                double precio = Double.parseDouble(vista.getVentanaInserccion().getJTPrecio().getText());
                int inventario = Integer.parseInt(vista.getVentanaInserccion().getJTInventario().getText());

                if (!vista.getTablaProducto().verificarExistencia(nombre)) {

                    
                    Producto nuevoProducto = new Producto(nombre, precio, inventario);
                    InterfazProducto producto = new InterfazProducto(nuevoProducto);
                    
                    RegistroProducto nuevoRegistro = new RegistroProducto(repositorio.save(nuevoProducto).getCodigo(),
                            nombre, precio, inventario, "Agregar",
                            usuarioRepositorio.getUsuario(vista.getUsuario().getIdCliente()).get(),fecha(),hora());
                    historial.getTablaRegistros().insertarRegistro(new InterfazRegistro(nuevoRegistro));
                    registroProducto.save(nuevoRegistro);
                    
                    
                    producto.getDetalleProducto().addMouseListener(accionDetalleProducto(producto));
                    producto.getPosicionOperador().addMouseListener(eliminarProducto(producto));
                    
                    vista.getTablaProducto().agregarProducto(producto);

                    vista.getVentanaInserccion().borrarTexto();
                    vista.getVentanaInserccion().definirVisibilidad(false);
                    JOptionPane.showMessageDialog(vista, "El producto " + nombre + " ha sido agregado en la base de datos", "Informacion", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirmacion.png"));
                } else {
                    vista.getVentanaInserccion().borrarTexto();
                    // mennsaje de eror si el producto ya esta agregado a la base de datos  
                    JOptionPane.showMessageDialog(vista.getVentanaInserccion(), "El producto ya existe en la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // mostrar el error
                JOptionPane.showMessageDialog(registro, "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception sinDatos){
            // mostrar el error
            JOptionPane.showMessageDialog(vista.getVentanaActualizar(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n" + sinDatos.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        

    }

    /**
     * Abrir la ventana de actualizar productos
     *
     * @param ae ActioneEvent
     */
    public void abrirVentanaActualizar(ActionEvent ae) {

        boolean verificador = false;

        for (InterfazProducto producto : vista.getTablaProducto().getListaProductos()) {
            if (producto.isSeleccionado()) {
                verificador = true;
                vista.getVentanaActualizar().getJTNombre().setText(producto.getProducto().getNombre());
                vista.getVentanaActualizar().getJTPrecio().setText(Double.toString(producto.getProducto().getPrecio()));
                vista.getVentanaActualizar().getJTInventario().setText(Integer.toString(producto.getProducto().getInventario()));
                vista.getVentanaActualizar().definirVisibilidad(true);
            }
        }

        if (!verificador) {
            // si no, abrira un JOptionPane para pedir que seleccione un producto de la base de datos 
            JOptionPane.showMessageDialog(vista.getVentanaActualizar(), "Seleccione un producto de la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Actualizar Producto
     *
     * @param ae ActionEvent
     */
    public void actualizarProducto(ActionEvent ae) {

        try {
            if (!vista.getVentanaActualizar().getJTNombre().getText().isEmpty()
                    && !vista.getVentanaActualizar().getJTPrecio().getText().isEmpty()
                    && !vista.getVentanaActualizar().getJTInventario().getText().isEmpty()) {

                String nombre = vista.getVentanaActualizar().getJTNombre().getText();
                double precio = Double.parseDouble(vista.getVentanaActualizar().getJTPrecio().getText());
                int inventario = Integer.parseInt(vista.getVentanaActualizar().getJTInventario().getText());

                for (InterfazProducto producto : vista.getTablaProducto().getListaProductos()) {
                    if (producto.isSeleccionado()) {

                        Producto productoAcualizado = repositorio.getProducto(producto.getProducto().getCodigo()).get();
                        
                        String verificarNombre = nombre;
                        Double verificarPrecio = precio;
                        Integer verificarInventario = inventario;
                        if (productoAcualizado.getNombre()== nombre) {
                            verificarNombre = null;
                        }
                        if (productoAcualizado.getPrecio() == precio) {
                            verificarPrecio = null;
                        }
                        if (productoAcualizado.getInventario() == inventario) {
                            verificarInventario = null;
                        }
                        
                        productoAcualizado.setNombre(nombre);
                        productoAcualizado.setPrecio(precio);
                        productoAcualizado.setInventario(inventario);
                        repositorio.save(productoAcualizado);
                        
                        
                        RegistroProducto nuevoRegistro = new RegistroProducto(productoAcualizado.getCodigo(),
                                verificarNombre, verificarPrecio, verificarInventario, "Actualizar",
                                usuarioRepositorio.getUsuario(vista.getUsuario().getIdCliente()).get(),fecha(),hora());
                        
                        historial.getTablaRegistros().insertarRegistro(new InterfazRegistro(nuevoRegistro));
                        registroProducto.save(nuevoRegistro);
                        
                        
                        
                        producto.getProducto().setNombre(nombre);
                        producto.getProducto().setPrecio(precio);
                        producto.getProducto().setInventario(inventario);
                        producto.actualizarProducto();

                        vista.getVentanaActualizar().borrarTexto();
                        vista.getVentanaActualizar().definirVisibilidad(false);
                        // enviar mensaje de validacion
                        JOptionPane.showMessageDialog(vista, "El producto " + nombre + " ha sido actualizado en la base de datos", "Informacion", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirmacion.png"));
                    }

                }
            } else {
                // mostrar el error
                JOptionPane.showMessageDialog(registro, "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception sinDatos) {
            // mostrar el error
            JOptionPane.showMessageDialog(vista.getVentanaActualizar(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n" + sinDatos.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * Generar informe
     *
     * @param ae ActionEvent
     */
    public void informe(ActionEvent ae) {

        JOptionPane.showMessageDialog(vista.getVentanaActualizar(), "Precio Mayor:   " + vista.getTablaProducto().productoMayor()
                + "\nPrecio Menor:   " + vista.getTablaProducto().productoMenor()
                + "\nPromedio Precio:   " + vista.getTablaProducto().promedioPrecios()
                + "\nValor Total Inventario:   " + vista.getTablaProducto().valorInventario(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     *
     * @param producto InterfazProducto
     * @return Retorna un MouseListener
     */
    public MouseListener accionDetalleProducto(InterfazProducto producto) {

        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                producto.setSeleccionado(true);
                vista.getTablaProducto().unicaSeleccionada(producto);
                producto.getDetalleProducto().setIcon(producto.getActualizarProducto());
                producto.getPosicionOperador().setIcon(producto.getActualizarPosicion());
                producto.definirColorTexto(producto.getColorContraste());
                producto.getTextoNumero().setText("");
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

                if (!producto.isSeleccionado()) {

                    producto.getPosicionOperador().setIcon(producto.getEliminarPosicion());
                    producto.getTextoNumero().setText("");
                    producto.getDetalleProducto().setIcon(producto.getEliminarProducto());
                    producto.definirColorTexto(producto.getColorContraste());
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                if (!producto.isSeleccionado()) {

                    producto.getDetalleProducto().setIcon(producto.getDefaultProducto());
                    producto.getPosicionOperador().setIcon(producto.getDefaultPosicion());
                    producto.getTextoNumero().setText(Integer.toString(producto.getPosicion()));
                    producto.definirColorTexto(producto.getColorDefault());
                }

            }
        };

        return accion;

    }

    /**
     *
     * @param producto InterfazProducto
     * @return Retorna un MouseListener para eliminar productos
     */
    public MouseListener eliminarProducto(InterfazProducto producto) {

        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (!producto.isSeleccionado()) {

                    int opcion = JOptionPane.showConfirmDialog(vista, "¿Desea eliminar el producto " + producto.getProducto().getNombre() + " de la base de datos?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (opcion == JOptionPane.YES_NO_OPTION) {

                        repositorio.delete(producto.getProducto());
                        
                        RegistroProducto nuevoRegistro = new RegistroProducto(producto.getProducto().getCodigo(), producto.getProducto().getNombre(),
                                producto.getProducto().getPrecio(), producto.getProducto().getInventario(),
                                "Eliminar", usuarioRepositorio.getUsuario(vista.getUsuario().getIdCliente()).get(), fecha(),hora());
                        
                        historial.getTablaRegistros().insertarRegistro(new InterfazRegistro(nuevoRegistro));
                        
                        registroProducto.save(nuevoRegistro);
                        vista.getTablaProducto().getListaProductos().remove(producto);
                        vista.getTablaProducto().remove(producto);

                        vista.getTablaProducto().ordenarTabla();
                        vista.getTablaProducto().updateUI();
                        JOptionPane.showMessageDialog(vista, "El producto " + producto.getProducto().getNombre() + " fue eliminado de la base de datos", "Informacion", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirmacion.png"));

                    }

                } else {

                    producto.setSeleccionado(false);
                    producto.getDetalleProducto().setIcon(producto.getDefaultProducto());
                    producto.getPosicionOperador().setIcon(producto.getDefaultPosicion());
                    producto.definirColorTexto(producto.getColorDefault());
                    producto.getTextoNumero().setText(Integer.toString(producto.getPosicion()));

                }
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                if (!producto.isSeleccionado()) {

                    producto.getPosicionOperador().setIcon(producto.getEliminarPosicion());
                    producto.getTextoNumero().setText("");
                    producto.getDetalleProducto().setIcon(producto.getEliminarProducto());
                    producto.definirColorTexto(producto.getColorContraste());

                }
            }

            @Override
            public void mouseExited(MouseEvent me) {

                if (!producto.isSeleccionado()) {

                    producto.getDetalleProducto().setIcon(producto.getDefaultProducto());
                    producto.getPosicionOperador().setIcon(producto.getDefaultPosicion());
                    producto.getTextoNumero().setText(Integer.toString(producto.getPosicion()));
                    producto.definirColorTexto(producto.getColorDefault());

                }

            }
        };

        return accion;
    }

    
    public void listarRegistros (){
        List<RegistroProducto> listaRegistro = (List<RegistroProducto>) registroProducto.getAll();

        for (RegistroProducto historialRegistro : listaRegistro) {

            InterfazRegistro nuevoRegistro = new InterfazRegistro(historialRegistro);

            historial.getTablaRegistros().insertarRegistro(nuevoRegistro);
        }
    }
    /**
     * Lista los productos de la base de datos dentro de la tabla
     */
    public void listarProducto() {
        List<Producto> listaProductos = (List<Producto>) repositorio.getAll();

        for (Producto producto : listaProductos) {

            InterfazProducto nuevoProducto = new InterfazProducto(producto);
            nuevoProducto.getDetalleProducto().addMouseListener(accionDetalleProducto(nuevoProducto));
            nuevoProducto.getPosicionOperador().addMouseListener(eliminarProducto(nuevoProducto));

            vista.getTablaProducto().agregarProducto(nuevoProducto);

        }
    }

    /**
     *
     * *******************************************************************************************************************************************************
     * ---------------------------------------------------------------------RegistroUsuarios --------------------------------------------------------------
     * *******************************************************************************************************************************************************
     *
     */
    public void listarUsuarios() {
        List<Usuario> listaUsuario = (List<Usuario>) usuarioRepositorio.getAll();

        for (Usuario usuario : listaUsuario) {
            
            InterfazUsuario nuevoUsuario = new InterfazUsuario(usuario);
            nuevoUsuario.getImagenUsuario().addMouseListener(accionImagenUsuario(nuevoUsuario));
            nuevoUsuario.getImagenPosicion().addMouseListener(eliminarUsuario(nuevoUsuario));
            registro.getTablaUsuarios().insertarUsuario(nuevoUsuario);
        }
    }

    /**
     *
     * @param ae
     */
    public void atrasRegistro(ActionEvent ae) {
        registro.setVisible(false);
        vista.setVisible(true);
    }
    
    /**
     * Registroo de usuarios
     */
    public void registrarUsuario(ActionEvent ae) {
        try {
            if (!registro.getRegistrarNombre().getText().isEmpty()
                    && !registro.getRegistrarCorreo().getText().isEmpty()
                    && !registro.getRegistrarContraseña().getText().isEmpty()) {

                String nombre = registro.getRegistrarNombre().getText();
                String correo = registro.getRegistrarCorreo().getText();
                String contraseña = registro.getRegistrarContraseña().getText();
                String rango;
                if (registro.getRango().isSelected()) {
                    rango = "Administrador";
                } else {
                    rango = "Sin rango";
                }

                if (!registro.getTablaUsuarios().verificarExistencia(nombre)) {
                    if (!registro.getTablaUsuarios().verificarExistenciaCorreo(correo)) {
                        InterfazUsuario usuario = new InterfazUsuario(usuarioRepositorio.save(new Usuario(nombre, correo, contraseña, rango)));
                        
                        usuario.getImagenUsuario().addMouseListener(accionImagenUsuario(usuario));
                        usuario.getImagenPosicion().addMouseListener(eliminarUsuario(usuario));
                        
                        registro.getTablaUsuarios().insertarUsuario(usuario);

                        registro.borrarTexto();
                        JOptionPane.showMessageDialog(registro, "El usuario " + nombre + " ha sido agregado en la base de datos", "Informacion", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirmacion.png"));
                    } else {
                        registro.borrarTexto();
                        // mennsaje de eror si el producto ya esta agregado a la base de datos
                        JOptionPane.showMessageDialog(registro, "El correo ya existe en la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    registro.borrarTexto();
                    // mennsaje de eror si el producto ya esta agregado a la base de datos
                    JOptionPane.showMessageDialog(registro, "El usuario ya existe en la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // mostrar el error
                JOptionPane.showMessageDialog(registro, "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception sinDatos) {
            JOptionPane.showMessageDialog(vista.getVentanaActualizar(), "Todo lo que pudo haber hecho mal, lo ha hecho\nLLene todos los campos con los valores solicitados\nError:\n" + sinDatos.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    /**
     * Eliminar usuario
     * @param usuario
     * @return 
     */
    public MouseListener eliminarUsuario(InterfazUsuario usuario) {

        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                

                    int opcion = JOptionPane.showConfirmDialog(registro, "¿Desea eliminar el usuario " + usuario.getUsuario().getNombre() + " de la base de datos?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (opcion == JOptionPane.YES_NO_OPTION) {

                        usuarioRepositorio.delete(usuario.getUsuario());

                        registro.getTablaUsuarios().getListaUsuarios().remove(usuario);
                        registro.getTablaUsuarios().remove(usuario);

                        registro.getTablaUsuarios().ordenarTabla();
                        registro.getTablaUsuarios().updateUI();
                        JOptionPane.showMessageDialog(registro, "El Usuario " + usuario.getUsuario().getNombre() + " fue eliminado de la base de datos", "Informacion", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirmacion.png"));

                    }

                
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                

                    usuario.getImagenPosicion().setIcon(usuario.getEliminarUsuarioPosicion());
                    usuario.getTextoNumero().setText("");
                    usuario.getImagenUsuario().setIcon(usuario.getEliminarUsuarioImagen());
                    usuario.definirColorTexto(usuario.getColorContraste());

                
            }

            @Override
            public void mouseExited(MouseEvent me) {

                

                    usuario.getImagenUsuario().setIcon(usuario.getDefaultImagen());
                    usuario.getImagenPosicion().setIcon(usuario.getDefaultPosicion());
                    usuario.getTextoNumero().setText(Integer.toString(usuario.getPosicion()));
                    usuario.definirColorTexto(usuario.getColorDefault());

                

            }
        };

        return accion;
    }

    public MouseListener accionImagenUsuario(InterfazUsuario usuario) {

        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

                

                    usuario.getImagenPosicion().setIcon(usuario.getEliminarUsuarioPosicion());
                    usuario.getTextoNumero().setText("");
                    usuario.getImagenUsuario().setIcon(usuario.getEliminarUsuarioImagen());
                    usuario.definirColorTexto(usuario.getColorContraste());
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                

                    usuario.getImagenUsuario().setIcon(usuario.getDefaultImagen());
                    usuario.getImagenPosicion().setIcon(usuario.getDefaultPosicion());
                    usuario.getTextoNumero().setText(Integer.toString(usuario.getPosicion()));
                    usuario.definirColorTexto(usuario.getColorDefault());
                

            }
        };

        return accion;

    }
    
    
    
    
    public String fecha(){
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        return formato.format(fechaActual);
    }
    public String hora (){
        Date horaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm aaa");
        return formato.format(horaActual);
    }
}
