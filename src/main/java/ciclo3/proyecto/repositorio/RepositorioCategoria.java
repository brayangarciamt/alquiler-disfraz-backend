package ciclo3.proyecto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciclo3.proyecto.modelo.Categoria;

@Repository
public interface RepositorioCategoria extends CrudRepository<Categoria,Integer>{
    
}
