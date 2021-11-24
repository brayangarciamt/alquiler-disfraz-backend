package ciclo3.proyecto.modelo;

public class ReporteCliente {
    
    private Integer total;
    private Cliente client;


    public ReporteCliente() {

        /**
         * Contructor vacio
         */
    }


    public ReporteCliente(Integer total, Cliente client) {
        this.total = total;
        this.client = client;
    }


    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }


    public Cliente getClient() {
        return client;
    }


    public void setClient(Cliente client) {
        this.client = client;
    }

    
}
