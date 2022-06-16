/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;


import co.edu.usa.restg33.model.Usuario;
import co.edu.usa.restg33.repository.crud.RepositorioUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class UsuarioRepository {
    @Autowired
    private RepositorioUsuario repositoriUsuario;
    
    public List<Usuario> getAll(){
        return (List<Usuario>) repositoriUsuario.findAll();
    }
    
    public Optional<Usuario> getUsuario(int id){
        return repositoriUsuario.findById(id);
    }
    
    public Usuario save(Usuario usuario){
        return repositoriUsuario.save(usuario);
    }
    
    public void delete(Usuario usuario){
        repositoriUsuario.delete(usuario);
    }
    
    public void deleteById(Integer id){
        repositoriUsuario.deleteById(id);
    }
}
