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
import org.springframework.web.bind.annotation.RequestMethod;

import ciclo3.proyecto.modelo.Disfraz;
import ciclo3.proyecto.servicios.ImplementacionServiciosDisfraz; 

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorDisfraz {

    @Autowired
    ImplementacionServiciosDisfraz serviciosDisfraz;

    @GetMapping("/all")
    public List<Disfraz> ListadoDisfraces() {
        return serviciosDisfraz.listarDisfraces();              
    }

    @GetMapping("/{id}")
    public Optional<Disfraz> detalleDisfraz(@PathVariable("id") Integer id){
        return serviciosDisfraz.listarDisfrazId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz anadirDisfraz(@RequestBody Disfraz disfraz){
        return serviciosDisfraz.crearDisfraz(disfraz);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarDisfraz(@PathVariable("id") Integer id){
        return serviciosDisfraz.borrarDisfraz(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz actualizarDisfraz(@RequestBody Disfraz disfraz){
        return serviciosDisfraz.actualizaDisfraz(disfraz);
    }

}