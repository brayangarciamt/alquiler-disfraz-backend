package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ciclo3.proyecto.modelo.Mensaje;
import ciclo3.proyecto.repositorio.RepositorioMensaje;

@Service
public class ImplementacionServiciosMensaje implements ServiciosMensaje{

    @Autowired
    RepositorioMensaje repositorioMensaje;

    @Override
    public List<Mensaje> listarMensajes() {
        return (List<Mensaje>) repositorioMensaje.findAll();
    }

    @Override
    public Optional<Mensaje> listarMensajeId(Integer id) {
        return repositorioMensaje.findById(id);
    }

    @Override
    public Mensaje crearMensaje(Mensaje mensaje) {

        return repositorioMensaje.save(mensaje);
        
        // if (repositorioMensaje.findById(mensaje.getIdMessage()).isPresent()){
        //     return null;
        // }
        // else{
        //     return repositorioMensaje.save(mensaje);
        // }
    }

    @Override
    public boolean borrarMensaje(Integer id) {
        boolean estado = true;

        if (repositorioMensaje.findById(id).isPresent()){
            repositorioMensaje.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }
    
    @Override
    public Mensaje actualizaMensaje(Mensaje mensaje) {

        return repositorioMensaje.save(mensaje);

        // if (repositorioMensaje.findById(mensaje.getIdMessage()).isPresent()){
        //     return repositorioMensaje.save(mensaje);
        // }
        // else{
        //     return null;
        // }
    }
}
