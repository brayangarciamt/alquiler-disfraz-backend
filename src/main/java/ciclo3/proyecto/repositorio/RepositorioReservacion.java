package ciclo3.proyecto.repositorio;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ciclo3.proyecto.modelo.Reservacion;

@Repository
public interface RepositorioReservacion extends CrudRepository<Reservacion,Integer>{

    // @Query(value = "SELECT * FROM reservacion WHERE startDate>=:fechaInicial AND devolutionDate<=:fechaFinal", 
    //             nativeQuery = true)

    // public List<Reservacion> listadoReservacionesIntervalo(@Param("fechaInicial") Date fechaInicial,
    //                                                         @Param("fechaFinal") Date fechaFinal);
    
    @Query("SELECT r FROM Reservacion r WHERE r.startDate>=:fechaInicial AND r.devolutionDate<=:fechaFinal")
    public List<Reservacion> listadoReservacionesIntervaloRepo(@Param("fechaInicial") Date fechaInicial,
                                                                @Param("fechaFinal") Date fechaFinal);

    @Query("SELECT COUNT(c.status) FROM Reservacion c WHERE c.status='completed'")
    public Integer listadoReservacionesCompletadas();

    @Query("SELECT COUNT(c.status) FROM Reservacion c WHERE c.status='cancelled'")
    public Integer listadoReservacionesCanceladas();

}
