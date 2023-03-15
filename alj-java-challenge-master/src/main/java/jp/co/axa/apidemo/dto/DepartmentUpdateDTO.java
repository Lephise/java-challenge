package jp.co.axa.apidemo.dto;

import lombok.Getter;
import lombok.Setter;

// Update DTO for Departments
public class DepartmentUpdateDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;
}
