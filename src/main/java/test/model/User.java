package test.model;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
public class User {

    private long id;

    @Size(min = 2, max = 50)
    private String firstName;

    @Size(min = 2, max = 50)
    private String lastName;

    @Min(14)
    @Max(150)
    private short age;

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
