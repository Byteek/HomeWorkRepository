package by.it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Entity @Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column
    private Integer age;

    @Column
    private String name;

    @Column
    private String surname;



}
