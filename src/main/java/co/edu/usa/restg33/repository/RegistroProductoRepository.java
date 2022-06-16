/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;


import co.edu.usa.restg33.model.RegistroProducto;
import co.edu.usa.restg33.repository.crud.RepositorioRegistroProducto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class RegistroProductoRepository {
    @Autowired
    private RepositorioRegistroProducto repositorioRegistroProducto;
    
    public List<RegistroProducto> getAll(){
        return (List<RegistroProducto>) repositorioRegistroProducto.findAll();
    }
    
    public Optional<RegistroProducto> getRegistroProducto(int id){
        return repositorioRegistroProducto.findById(id);
    }
    
    public RegistroProducto save(RegistroProducto registroProducto){
        return repositorioRegistroProducto.save(registroProducto);
    }
    
    public void delete(RegistroProducto registroProducto){
        repositorioRegistroProducto.delete(registroProducto);
    }
    
    public void deleteById(Integer id){
        repositorioRegistroProducto.deleteById(id);
    }
}
