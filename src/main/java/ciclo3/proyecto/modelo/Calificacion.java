package ciclo3.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "calificacion")
/**
 * Clase calificacion
 */
public class Calificacion {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 250)
    private Integer score;

    @Column(length = 250)
    private String scoreMessage;

    public Calificacion() {
        /**
         * Constructor vacio
         */
    }

    public Calificacion(Integer id, Integer score, String scoreMessage) {
        this.id = id;
        this.score = score;
        this.scoreMessage = scoreMessage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreMessage() {
        return scoreMessage;
    }

    public void setScoreMessage(String scoreMessage) {
        this.scoreMessage = scoreMessage;
    }

    

}
