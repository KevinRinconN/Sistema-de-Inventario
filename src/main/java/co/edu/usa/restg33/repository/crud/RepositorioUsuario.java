/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.restg33.repository.crud;


import co.edu.usa.restg33.model.Usuario;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author kevin
 */

public interface RepositorioUsuario  extends CrudRepository<Usuario, Integer> {
    
}
