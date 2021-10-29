package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciclo3.proyecto.modelo.Cliente;
import ciclo3.proyecto.repositorio.RepositorioCliente;

@Service
public class ImplementacionServiciosCliente implements ServiciosCliente{
    
    @Autowired
    RepositorioCliente repositorioCliente;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) repositorioCliente.findAll();
    }

    @Override
    public Optional<Cliente> listarClienteId(Integer id) {
        return repositorioCliente.findById(id);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {

        return repositorioCliente.save(cliente);

        // if (repositorioCliente.findById(cliente.getIdClient()).isPresent()){
        //     return null;
        // }
        // else{
        //     return repositorioCliente.save(cliente);
        // }
    }

    @Override
    public boolean borrarCliente(Integer id) {
        boolean estado = true;

        if (repositorioCliente.findById(id).isPresent()){
            repositorioCliente.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Cliente actualizaCliente(Cliente cliente) {

        return repositorioCliente.save(cliente);

        // if (repositorioCliente.findById(cliente.getIdClient()).isPresent()){
        //     return repositorioCliente.save(cliente);
        // }
        // else{
        //     return null;
        // }
    }
}
