package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ciclo3.proyecto.modelo.Mensaje;

@Component
public interface ServiciosMensaje {

    public List<Mensaje> listarMensajes();
    public Optional<Mensaje> listarMensajeId(Integer id);
    public Mensaje crearMensaje(Mensaje mensaje);
    public boolean borrarMensaje(Integer id);
    public Mensaje actualizaMensaje(Mensaje mensaje);
}
