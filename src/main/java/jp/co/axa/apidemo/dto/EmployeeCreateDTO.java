package jp.co.axa.apidemo.dto;

import lombok.Getter;
import lombok.Setter;

// DTO for Employee creation
public class EmployeeCreateDTO {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer salary;

    @Getter
    @Setter
    private Long departmentId;
}
