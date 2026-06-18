package andreasaderi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    protected Person() {
    }

    public Person(String name, String surname, String email, LocalDate birthDate, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
