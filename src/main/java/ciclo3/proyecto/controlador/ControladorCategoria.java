package ciclo3.proyecto.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ciclo3.proyecto.modelo.Categoria;
import ciclo3.proyecto.servicios.ImplementacionServiciosCategoria;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorCategoria {
    
    @Autowired
    ImplementacionServiciosCategoria serviciosCategoria;

    @GetMapping("/all")
    public List<Categoria> listadoCategorias() {
        return serviciosCategoria.listarCategorias();              
    }

    @GetMapping("/{id}")
    public Optional<Categoria> detalleCategoria(@PathVariable("id") Integer id){
        return serviciosCategoria.listarCategoriaId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria anadirCategoria(@RequestBody Categoria categoria){
        return serviciosCategoria.crearCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCategoria(@PathVariable("id") Integer id){
        return serviciosCategoria.borrarCategoria(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Categoria actualizarCategoria(@RequestBody Categoria categoria){
        return serviciosCategoria.actualizaCategoria(categoria);
    }
}

