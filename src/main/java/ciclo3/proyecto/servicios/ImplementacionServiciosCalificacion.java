package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ciclo3.proyecto.modelo.Calificacion;
import ciclo3.proyecto.repositorio.RepositorioCalificacion;

@Service
public class ImplementacionServiciosCalificacion implements ServiciosCalificacion{

    @Autowired
    RepositorioCalificacion repositorioCalificacion;

    @Override
    public List<Calificacion> listarCalificaciones() {
        return (List<Calificacion>) repositorioCalificacion.findAll();
    }

    @Override
    public Optional<Calificacion> listarCalificacionId(Integer id) {
        return repositorioCalificacion.findById(id);
    }

    @Override
    public Calificacion crearCalificacion(Calificacion calificacion) {
        
        return repositorioCalificacion.save(calificacion);

    }

    @Override
    public boolean borrarCalificacion(Integer id) {
        boolean estado = true;

        if (repositorioCalificacion.findById(id).isPresent()){
            repositorioCalificacion.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Calificacion actualizaCalificacion(Calificacion calificacion) {

        if (repositorioCalificacion.findById(calificacion.getId()).isPresent()){
            
            Optional<Calificacion> calificacionCopia = repositorioCalificacion.findById(calificacion.getId());

            if(calificacion.getScore()!=calificacionCopia.get().getScore()
                &&calificacion.getScore()!=null){
                    calificacionCopia.get().setScore(calificacion.getScore());
                }
                
            if(calificacion.getScoreMessage()!=calificacionCopia.get().getScoreMessage()
            &&!calificacion.getScoreMessage().isEmpty()){
                calificacionCopia.get().setScoreMessage(calificacion.getScoreMessage());
                }

            return repositorioCalificacion.save(calificacionCopia.get());
        }
        else{
            return null;
        }
    }
    
}
