package test.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "age")
    private short age;
    @Column(name = "haspremium")
    private boolean hasPremium;
    @Column(name = "lastauthorization")
    private LocalDate lastAuthorization;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public short getAge() {
        return age;
    }

    public boolean isHasPremium() {
        return hasPremium;
    }

    public LocalDate getLastAuthorization() {
        return lastAuthorization;
    }

}
