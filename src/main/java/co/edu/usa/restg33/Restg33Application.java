package co.edu.usa.restg33;


import co.edu.usa.restg33.model.Producto;
import co.edu.usa.restg33.model.RegistroProducto;
import co.edu.usa.restg33.model.Usuario;
import co.edu.usa.restg33.repository.ProductoRepository;
import co.edu.usa.restg33.repository.RegistroProductoRepository;
import co.edu.usa.restg33.repository.UsuarioRepository;
import co.edu.usa.restg33.view.Login;
import co.edu.usa.restg33.view.RegistroUsuarios;
import co.edu.usa.restg33.view.Vista;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@EntityScan(basePackages = {"co.edu.usa.restg33.model"})
@SpringBootApplication
public class Restg33Application {

    @Autowired
    private ProductoRepository repoCategory;
    @Autowired
    private RegistroProductoRepository repoClient;
    @Autowired
    private UsuarioRepository repoUsuario;
    
    
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Restg33Application.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
        
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            
            Vista vista = new Vista();
            RegistroUsuarios registro = new RegistroUsuarios();
            Login login = new Login();
            Controlador controlador = new Controlador(repoCategory,repoUsuario,repoClient,vista,registro, login);
            
            List<Producto> pca = repoCategory.getAll();
            System.out.println("Producto: "+pca.size());
            
            List<RegistroProducto> pc = repoClient.getAll();
            System.out.println("Registros: "+pc.size());
            
            List<Usuario> pm = repoUsuario.getAll();
            System.out.println("Usuarios: "+pm.size());
            
        };
    }
}
