package jp.co.axa.apidemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Entity describing Employee
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name="EMPLOYEE_NAME")
    private String name;

    @Getter
    @Setter
    @Column(name="EMPLOYEE_SALARY")
    private Integer salary;

    @Getter
    @Setter
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    @ManyToOne
    private Department department;

    @Getter
    @Setter
    @Column(name = "department_id")
    private Long departmentId;

}
