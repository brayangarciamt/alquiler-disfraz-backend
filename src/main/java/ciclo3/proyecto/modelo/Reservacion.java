package ciclo3.proyecto.modelo;

// import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "reservacion")
/**
 * Clase reservacion
 */
public class Reservacion{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idReservation;

    @Column
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    /**
     * Relacion muchos a unos con entidad Disfraz
     * 
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_costume")
    @JsonIgnoreProperties({"reservations"})
    private Disfraz costume;

    /**
     * Relacion muchos a uno con entidad Cliente
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cliente client;

    /**
     * Relacion uno a uno con entidad calificacion
     */
    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy = "reservation")
    @JsonIgnoreProperties({"reservation"})
    private Calificacion score;

    public Reservacion() {
        /**
         * Constructor vacio
         */
    }

    public Reservacion(Integer idReservation, Date startDate, Date devolutionDate, String status, Disfraz costume,
            Cliente client, Calificacion score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.costume = costume;
        this.client = client;
        this.score = score;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Disfraz getCostume() {
        return costume;
    }

    public void setCostume(Disfraz costume) {
        this.costume = costume;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Calificacion getScore() {
        return score;
    }

    public void setScore(Calificacion score) {
        this.score = score;
    }


    
}
