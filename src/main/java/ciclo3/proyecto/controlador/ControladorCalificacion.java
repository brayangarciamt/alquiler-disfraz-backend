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

import ciclo3.proyecto.modelo.Calificacion;
import ciclo3.proyecto.servicios.ImplementacionServiciosCalificacion;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorCalificacion {
    
    @Autowired
    ImplementacionServiciosCalificacion serviciosCalificacion;

    @GetMapping("/all")
    public List<Calificacion> listadoCalificaciones() {
        return serviciosCalificacion.listarCalificaciones();              
    }

    @GetMapping("/{id}")
    public Optional<Calificacion> detalleCalificacion(@PathVariable("id") Integer id){
        return serviciosCalificacion.listarCalificacionId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion anadirCalificacion(@RequestBody Calificacion calificacion){
        return serviciosCalificacion.crearCalificacion(calificacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCalificacion(@PathVariable("id") Integer id){
        return serviciosCalificacion.borrarCalificacion(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Calificacion actualizarCalificacion(@RequestBody Calificacion calificacion){
        return serviciosCalificacion.actualizaCalificacion(calificacion);
    }
}
