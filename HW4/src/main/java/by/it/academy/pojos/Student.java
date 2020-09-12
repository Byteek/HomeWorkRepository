package by.it.academy.pojos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Student  {
    private static final String serialVersionUUID = null;
    private String faculty;
    private Double mark;


}