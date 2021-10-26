package ciclo3.proyecto.modelo;

// import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mensaje")
/**
 * Clase mensaje
 */
public class Mensaje{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(length = 250)
    private String messageText;

    /**
     * Relacion muchos a uno con entidad Disfraz
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_costume")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Disfraz costume;

    /**
     * Relacion muchos a uno con entidad cliente
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;

    public Mensaje() {
        /**
         * Constructor vacio
         */
    }

    public Mensaje(Integer idMessage, String messageText, Disfraz costume, Cliente client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.costume = costume;
        this.client = client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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


}
