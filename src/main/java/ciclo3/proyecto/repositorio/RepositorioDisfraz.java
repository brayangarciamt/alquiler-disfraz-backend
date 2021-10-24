package ciclo3.proyecto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciclo3.proyecto.modelo.Disfraz;

@Repository
public interface RepositorioDisfraz extends CrudRepository<Disfraz,Integer>  {
    
}
