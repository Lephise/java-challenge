package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.components.ModelMapperComponent;
import jp.co.axa.apidemo.dto.EmployeeCreateDTO;
import jp.co.axa.apidemo.dto.EmployeeDTO;
import jp.co.axa.apidemo.dto.EmployeeUpdateDTO;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapperComponent mapperComponent;

    // Get for Employees. Returns list of Employees.
    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployees() {

        List<Employee> employees = employeeService.retrieveEmployees();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        //TODO: Investigate how to correctly map the department name in EmployeeDTO from the Department entity in Employee!!
        //The example below does not map inner objects (relationship for Department) correctly
        //List<EmployeeDTO> employeesDTO = mapper.map(employees, new TypeToken<List<EmployeeDTO>>() {}.getType());
        for(Employee employee : employees) {
            EmployeeDTO empDto = mapperComponent.getMapper().map(employee, EmployeeDTO.class);
            empDto.setDepartment(employee.getDepartment().getName());
            employeeDTOs.add(empDto);
        }

        return employeeDTOs;
    }

    // Get for Employees by ID. Returns an Employee based on ID.
    @GetMapping("/employees/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        EmployeeDTO employeeDTO = mapperComponent.getMapper().map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

    // Post for Employees. Saves a new Employee to the database.
    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployee(EmployeeCreateDTO employeeDTO){
        Employee employee = mapperComponent.getMapper().map(employeeDTO, Employee.class);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<String>("Employee Saved Successfully", HttpStatus.OK);
    }

    // Delete for Employee. Deletes an Employee based on ID.
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
    }

    // Put for Employees. Updates an existing Employee.
    @PutMapping("/employees")
    public ResponseEntity<String> updateEmployee(EmployeeUpdateDTO employeeDTO){
        //System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Employee emp = employeeService.getEmployee(employeeDTO.getId());
        if(emp != null){
            Employee employee = mapperComponent.getMapper().map(employeeDTO, Employee.class);
            employeeService.updateEmployee(employee);
            return new ResponseEntity<String>("Employee Updated", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Employee not Found!", HttpStatus.NOT_FOUND);

    }

}
