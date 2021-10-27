package ciclo3.proyecto.modelo;

// import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cliente")
/**
 * Cliente
 */
public class Cliente{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idClient;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column(length = 250)
    private String name;

    @Column(length = 3)
    private Integer age;
    
    /**
     * Relacion uno a muchos con entidad Mensaje
     * 
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties({"costume","client"})
    private List<Mensaje> messages;

    /**
     * Relacion uno a muchos con reservaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties({"costume","client"})
    private List<Reservacion> reservations;

    public Cliente() {
        /**
         * Constructor vacio
         */

    }

    public Cliente(Integer idClient, String name, String email, String password, Integer age, List<Mensaje> messages,
            List<Reservacion> reservations) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservacion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }

        
}