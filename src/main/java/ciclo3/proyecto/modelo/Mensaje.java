package ciclo3.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensaje")
/**
 * Clase mensaje
 */
public class Mensaje {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(length = 250)
    private String messageText;

    

    public Mensaje() {
        /**
         * Constructor vacio
         */
    }

    public Mensaje(Integer idMessage, String messageText) {
        this.idMessage = idMessage;
        this.messageText = messageText;
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

}
