package jp.co.axa.apidemo.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for updating Employees
public class EmployeeUpdateDTO extends EmployeeCreateDTO{
    @Getter
    @Setter
    private Long id;
}
