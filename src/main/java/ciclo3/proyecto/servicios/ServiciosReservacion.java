package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ciclo3.proyecto.modelo.Reservacion;

@Component
public interface ServiciosReservacion {

    public List<Reservacion> listarReservaciones();
    public Optional<Reservacion> listarReservacionId(Integer id);
    public Reservacion crearReservacion(Reservacion reservacion);
    public boolean borrarReservacion(Integer id);
    public Reservacion actualizaReservacion(Reservacion reservacion);
}
