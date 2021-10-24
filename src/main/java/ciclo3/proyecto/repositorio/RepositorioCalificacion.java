package ciclo3.proyecto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciclo3.proyecto.modelo.Calificacion;

@Repository
public interface RepositorioCalificacion extends CrudRepository<Calificacion,Integer>{
    
}
