package ciclo3.proyecto.controlador;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import ciclo3.proyecto.modelo.ReporteCliente;
import ciclo3.proyecto.modelo.Reservacion;
import ciclo3.proyecto.servicios.ImplementacionServiciosReservacion;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorReservacion {
    
    @Autowired
    ImplementacionServiciosReservacion serviciosReservacion;

    @GetMapping("/all")
    public List<Reservacion> listadoReservaciones() {
        return serviciosReservacion.listarReservaciones();              
    }

    @GetMapping("/{id}")
    public Optional<Reservacion> detalleReservacion(@PathVariable("id") Integer id){
        return serviciosReservacion.listarReservacionId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion anadirReservacion(@RequestBody Reservacion reservacion){
        return serviciosReservacion.crearReservacion(reservacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarReservacion(@PathVariable("id") Integer id){
        return serviciosReservacion.borrarReservacion(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion actualizarReservacion(@RequestBody Reservacion reservacion){
        return serviciosReservacion.actualizaReservacion(reservacion);
    }

    @GetMapping("/report-dates/{fechaInicial}/{fechaFinal}")
    public List<Reservacion> listadoReservacionesIntervalo(@PathVariable("fechaInicial")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicial,
                                                            @PathVariable("fechaFinal")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFinal) {
                                                                
        return serviciosReservacion.listarReservacionesIntervalo(fechaInicial,fechaFinal);              
    }

    @GetMapping("/report-status")
    public Map<String,Integer> listadoReservacionesCantidad() {
        
        return serviciosReservacion.listarReservacionesCantidad();              
    }

    @GetMapping("/report-clients")
    public List<ReporteCliente> listadoClientesTop() {
        
        return serviciosReservacion.listarClientesMelos();              
    }
}
