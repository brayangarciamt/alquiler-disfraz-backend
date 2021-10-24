package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ciclo3.proyecto.modelo.Calificacion;

@Component
public interface ServiciosCalificacion {

    public List<Calificacion> listarCalificaciones();
    public Optional<Calificacion> listarCalificacionId(Integer id);
    public Calificacion crearCalificacion(Calificacion calificacion);
    public boolean borrarCalificacion(Integer id);
}
