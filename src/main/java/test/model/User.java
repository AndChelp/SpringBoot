package test.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30)
    @Column(name = "firstname")
    private String firstName;

    @Size(min = 2, max = 30)
    @Column(name = "lastname")
    private String lastName;

    @Min(14)
    @Column(name = "age")
    private short age;

    @Column(name = "haspremium")
    private boolean hasPremium;

    @Column(name = "lastauthorization")
    private LocalDate lastAuthorization;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public boolean isHasPremium() {
        return hasPremium;
    }

    public void setHasPremium(boolean hasPremium) {
        this.hasPremium = hasPremium;
    }

    public LocalDate getLastAuthorization() {
        return lastAuthorization;
    }

    public void setLastAuthorization(LocalDate lastAuthorization) {
        this.lastAuthorization = lastAuthorization;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", hasPremium=" + hasPremium +
                ", lastAuthorization=" + lastAuthorization +
                '}';
    }
}
