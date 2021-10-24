package ciclo3.proyecto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciclo3.proyecto.modelo.Reservacion;

@Repository
public interface RepositorioReservacion extends CrudRepository<Reservacion,Integer>{
    
}
