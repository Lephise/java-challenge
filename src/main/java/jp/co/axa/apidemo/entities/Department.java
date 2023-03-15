package jp.co.axa.apidemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Entity describing a Department
@Entity
@Table(name="DEPARTMENT")
public class Department {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name="DEPARTMENT_NAME", unique = true)
    private String name;

}