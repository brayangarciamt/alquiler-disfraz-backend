package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ciclo3.proyecto.modelo.Disfraz;

@Component
public interface ServiciosDisfraz {
    
    public List<Disfraz> listarDisfraces();
    public Optional<Disfraz> listarDisfrazId(Integer id);
    public Disfraz crearDisfraz(Disfraz disfraz);
    public boolean borrarDisfraz(Integer id);
    public Disfraz actualizaDisfraz(Disfraz disfraz);
}
