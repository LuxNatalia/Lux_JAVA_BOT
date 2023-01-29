package org.telbot.telran.info.model;
/** class for definition user with fields id and name
 * @author Natalia Lux
 * @version 1.0
 */
import javax.persistence.*;

@Entity
@Table(name = "tg_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    public User() {
        //
    }

    public User(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User " + id + " " + name;
    }
}
