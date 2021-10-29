package ciclo3.proyecto.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ciclo3.proyecto.modelo.Mensaje;
import ciclo3.proyecto.servicios.ImplementacionServiciosMensaje;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorMensaje {
    
    @Autowired
    ImplementacionServiciosMensaje serviciosMensaje;

    @GetMapping("/all")
    public List<Mensaje> listadoMensajes() {
        return serviciosMensaje.listarMensajes();              
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> detalleMensaje(@PathVariable("id") Integer id){
        return serviciosMensaje.listarMensajeId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje anadirMensaje(@RequestBody Mensaje mensaje){
        return serviciosMensaje.crearMensaje(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarMensaje(@PathVariable("id") Integer id){
        return serviciosMensaje.borrarMensaje(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mensaje actualizaMensaje(@RequestBody Mensaje mensaje){
        return serviciosMensaje.actualizaMensaje(mensaje);
    }

}
