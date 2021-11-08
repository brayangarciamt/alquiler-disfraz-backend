package ciclo3.proyecto.modelo;

// import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="disfraz")

/**
 * Disfraz
 */
public class Disfraz{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String name;
    
    @Column(length = 45)
    private String brand;

    @Column(length = 4)
    private Integer year;

    @Column(length = 250)
    private String description;

    /**
     * Relacion muchos a uno con entidad Categoria
     * 
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_category")
    @JsonIgnoreProperties("costumes")
    private Categoria category;

    /**
     * relacion uno a muchos con entidad Mensaje
     */
    @OneToMany(cascade = {CascadeType.REMOVE},mappedBy = "costume")
    @JsonIgnoreProperties({"costume","client"})
    private List<Mensaje> messages;
    
    /**
     * relacion uno a muchos con entidad Reservacion
     */
    @OneToMany(cascade = {CascadeType.REMOVE},mappedBy = "costume")
    @JsonIgnoreProperties({"costume"})
    private List<Reservacion> reservations;

    public Disfraz() {
        /**
         * Constructor vacio
         */
    }

    public Disfraz(Integer id, String name, String brand, Integer year, String description, Categoria category,
            List<Mensaje> messages, List<Reservacion> reservations) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
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
