package ciclo3.proyecto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ciclo3.proyecto.modelo.Cliente;

@Component
public interface ServiciosCliente {

    public List<Cliente> listarClientes();
    public Optional<Cliente> listarClienteId(Integer id);
    public Cliente crearCliente(Cliente cliente);
    public boolean borrarCliente(Integer id);
    public Cliente actualizaCliente(Cliente cliente);
}
