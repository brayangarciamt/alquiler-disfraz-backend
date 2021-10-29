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

import ciclo3.proyecto.modelo.Cliente;
import ciclo3.proyecto.servicios.ImplementacionServiciosCliente; 

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorCliente {

    @Autowired
    ImplementacionServiciosCliente serviciosCliente;

    @GetMapping("/all")
    public List<Cliente> ListadoClientes() {
        return serviciosCliente.listarClientes();              
    }

    @GetMapping("/{id}")
    public Optional<Cliente> detalleCliente(@PathVariable("id") Integer id){
        return serviciosCliente.listarClienteId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente anadirCliente(@RequestBody Cliente disfraz){
        return serviciosCliente.crearCliente(disfraz);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCliente(@PathVariable("id") Integer id){
        return serviciosCliente.borrarCliente(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Cliente actualizarCliente(@RequestBody Cliente cliente){
        return serviciosCliente.actualizaCliente(cliente);
    }

}