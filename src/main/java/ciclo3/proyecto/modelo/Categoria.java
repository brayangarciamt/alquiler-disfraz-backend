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
@Table(name = "categoria")
/**
 * Clase categoria
 */

public class Categoria{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(length = 250)
    private String description;

    /**
     * relacion uno a muchos con entidad Disfraz
     * 
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties({"category","messages","reservations"})
    private List<Disfraz> costumes;

    public Categoria() {
        /**
         * Constructor vacio
         */
    }

    public Categoria(Integer id, String name, String description, List<Disfraz> costumes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.costumes = costumes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Disfraz> getCostumes() {
        return costumes;
    }

    public void setCostumes(List<Disfraz> costumes) {
        this.costumes = costumes;
    }

}
