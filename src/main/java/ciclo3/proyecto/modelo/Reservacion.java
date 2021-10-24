package ciclo3.proyecto.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservacion")
/**
 * Clase reservacion
 */
public class Reservacion{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idReservation;

    @Column(length = 250)
    private Date startDate;

    @Column
    private Date devolutionDate;

    @Column
    private String status;

    public Reservacion() {
        /**
         * Constructor vacio
         */
    }

    public Reservacion(Integer idReservation, Date startDate, Date devolutionDate, String status) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
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

}
