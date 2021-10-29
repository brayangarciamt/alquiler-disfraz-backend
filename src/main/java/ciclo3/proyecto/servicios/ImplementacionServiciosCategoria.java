package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciclo3.proyecto.modelo.Categoria;
import ciclo3.proyecto.repositorio.RepositorioCategoria;

@Service
public class ImplementacionServiciosCategoria implements ServiciosCategoria{
    
    @Autowired
    RepositorioCategoria repositorioCategoria;

    @Override
    public List<Categoria> listarCategorias() {
        return (List<Categoria>) repositorioCategoria.findAll();
    }

    @Override
    public Optional<Categoria> listarCategoriaId(Integer id) {
        return repositorioCategoria.findById(id);
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        

        if (repositorioCategoria.findById(categoria.getId()).isPresent()){
            return null;
        }
        else{
            return repositorioCategoria.save(categoria);
        }
    }

    @Override
    public boolean borrarCategoria(Integer id) {
        boolean estado = true;

        if (repositorioCategoria.findById(id).isPresent()){
            repositorioCategoria.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Categoria actualizaCategoria (Categoria categoria) {

        if (repositorioCategoria.findById(categoria.getId()).isPresent()){
            return repositorioCategoria.save(categoria);
        }
        else{
            return null;
        }
    }
}
