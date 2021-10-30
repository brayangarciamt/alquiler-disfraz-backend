package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ciclo3.proyecto.modelo.Reservacion;
import ciclo3.proyecto.repositorio.RepositorioReservacion;

@Service
public class ImplementacionServiciosReservacion implements ServiciosReservacion{

    @Autowired
    RepositorioReservacion repositorioReservacion;

    @Override
    public List<Reservacion> listarReservaciones() {
        return (List<Reservacion>) repositorioReservacion.findAll();
    }

    @Override
    public Optional<Reservacion> listarReservacionId(Integer id) {
        return repositorioReservacion.findById(id);
    }

    @Override
    public Reservacion crearReservacion(Reservacion reservacion) {
        
        return repositorioReservacion.save(reservacion);
    }

    @Override
    public boolean borrarReservacion(Integer id) {
        boolean estado = true;

        if (repositorioReservacion.findById(id).isPresent()){
            repositorioReservacion.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Reservacion actualizaReservacion (Reservacion reservacion) {

        if (repositorioReservacion.findById(reservacion.getIdReservation()).isPresent()){
            
            Optional<Reservacion> reservacionCopia = repositorioReservacion.findById(reservacion.getIdReservation());

            if(reservacion.getStartDate()!=reservacionCopia.get().getStartDate()
                &&reservacion.getStartDate()!=null){
                    reservacionCopia.get().setStartDate(reservacion.getStartDate());
                }

            if(reservacion.getDevolutionDate()!=reservacionCopia.get().getDevolutionDate()
            &&reservacion.getDevolutionDate()!=null){
                reservacionCopia.get().setDevolutionDate(reservacion.getDevolutionDate());
                }

            if(reservacion.getStatus()!=reservacionCopia.get().getStatus()
            &&reservacion.getStatus()!=null){
                reservacionCopia.get().setStatus(reservacion.getStatus());
                }
            
            return repositorioReservacion.save(reservacionCopia.get());
        }

        else{
            return null;
        }
    }
    
}
