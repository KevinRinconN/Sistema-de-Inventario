/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository;


import co.edu.usa.restg33.model.Producto;
import co.edu.usa.restg33.repository.crud.RepositorioProducto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kevin
 */
@Repository
public class ProductoRepository {
    @Autowired
    private RepositorioProducto repositorioProducto;
    
    public List<Producto> getAll(){
        return (List<Producto>) repositorioProducto.findAll();
    }
    
    public Optional<Producto> getProducto(int id){
        return repositorioProducto.findById(id);
    }
    
    public Producto save(Producto producto){
        return repositorioProducto.save(producto);
    }
    
    public void delete(Producto producto){
        repositorioProducto.delete(producto);
    }
    
    public void deleteById(Integer id){
        repositorioProducto.deleteById(id);
    }
}
