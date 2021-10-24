package ciclo3.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
/**
 * Cliente
 */
public class Cliente {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idClient;

    @Column(length = 250)
    private String name;

    @Column(length = 3)
    private Integer age;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    public Cliente() {
        /**
         * Constructor vacio
         */

    }

    public Cliente(Integer idClient, String name, Integer age, String email, String password) {
        this.idClient = idClient;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return "password";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}