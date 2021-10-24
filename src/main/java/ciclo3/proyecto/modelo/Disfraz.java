package ciclo3.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;

// @Data
// @Getter
// @Setter
@Entity
@Table(name="disfraz")

/**
 * Disfraz
 */
public class Disfraz {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 45)
    private String brand;

    @Column(length = 4)
    private Integer model;

    @Column
    private Integer category;

    @Column(length = 45)
    private String name;

    @Column(length = 250)
    private String description;
    
    public Disfraz() {
        /**
         * Constructor vacio
         */
    }

    public Disfraz(Integer id,String brand, Integer model, Integer category, String name, String description) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
