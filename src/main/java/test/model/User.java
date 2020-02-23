package test.model;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class User {

    private int id;

    @Size(min = 2, max = 50)
    private String firstName;

    @Size(min = 2, max = 50)
    private String lastName;

    @Min(14)
    @Max(150)
    private int age;

    private boolean hasPremium;

    private Date lastAuthorization;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                ", hasPremium=" + hasPremium +
                ", lastAuthorization=" + lastAuthorization +
                '}';
    }
}
