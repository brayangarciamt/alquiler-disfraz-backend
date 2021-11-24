package ciclo3.proyecto.servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ciclo3.proyecto.modelo.Categoria;

@Component
public interface ServiciosCategoria {

    public List<Categoria> listarCategorias();
    public Optional<Categoria> listarCategoriaId(Integer id);
    public Categoria crearCategoria(Categoria categoria);
    public boolean borrarCategoria(Integer id);
    public Categoria actualizaCategoria(Categoria categoria);
    
}
