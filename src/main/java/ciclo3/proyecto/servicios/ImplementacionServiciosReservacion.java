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
    
}
