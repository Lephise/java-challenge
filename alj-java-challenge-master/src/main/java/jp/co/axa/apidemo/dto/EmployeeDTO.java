package jp.co.axa.apidemo.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for getting Employees
public class EmployeeDTO {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer salary;

    @Getter
    @Setter
    private String department;

}
