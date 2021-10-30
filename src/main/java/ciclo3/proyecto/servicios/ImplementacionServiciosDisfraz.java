package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciclo3.proyecto.modelo.Disfraz;
import ciclo3.proyecto.repositorio.RepositorioDisfraz;

@Service
public class ImplementacionServiciosDisfraz implements ServiciosDisfraz{

    @Autowired
    RepositorioDisfraz repositorioDisfraz;

    @Override
    public List<Disfraz> listarDisfraces() {
        return (List<Disfraz>) repositorioDisfraz.findAll();
    }

    @Override
    public Optional<Disfraz> listarDisfrazId(Integer id) {
        return repositorioDisfraz.findById(id);
    }

    @Override
    public Disfraz crearDisfraz(Disfraz disfraz) {

        return repositorioDisfraz.save(disfraz);
    }

    @Override
    public boolean borrarDisfraz(Integer id) {
        boolean estado = true;

        if (repositorioDisfraz.findById(id).isPresent()){
            repositorioDisfraz.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Disfraz actualizaDisfraz(Disfraz disfraz) {

        if (repositorioDisfraz.findById(disfraz.getId()).isPresent()){

            Optional<Disfraz> disfrazCopia = repositorioDisfraz.findById(disfraz.getId());
            
            if(disfraz.getName()!=disfrazCopia.get().getName()
                &&!disfraz.getName().isEmpty()){
                    disfrazCopia.get().setName(disfraz.getName());
                }
                
            if(disfraz.getBrand()!=disfrazCopia.get().getBrand()
            &&!disfraz.getBrand().isEmpty()){
                disfrazCopia.get().setBrand(disfraz.getBrand());
                }

            if(disfraz.getYear()!=disfrazCopia.get().getYear()
            &&disfraz.getYear()!=null){
                disfrazCopia.get().setYear(disfraz.getYear());
                }

            if(disfraz.getDescription()!=disfrazCopia.get().getDescription()
            &&!disfraz.getDescription().isEmpty()){
                disfrazCopia.get().setDescription(disfraz.getDescription());
                }

            return repositorioDisfraz.save(disfrazCopia.get());
        }
        else{
            return null;
        }
        
    }
    
}
