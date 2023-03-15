package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.components.ModelMapperComponent;
import jp.co.axa.apidemo.dto.DepartmentDTO;
import jp.co.axa.apidemo.dto.DepartmentUpdateDTO;
import jp.co.axa.apidemo.dto.EmployeeDTO;
import jp.co.axa.apidemo.entities.Department;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ModelMapperComponent mapperComponent;

    // Get for departments. Returns list of departments
    @GetMapping("/departments")
    public List<DepartmentDTO> getDepartments() {
        List<Department> departments = departmentService.retrieveDepartments();
        List<DepartmentDTO> departmentDTOs = mapperComponent.getMapper().map(departments, new TypeToken<List<DepartmentDTO>>() {}.getType());
        return departmentDTOs;
    }

    // Get for departments by ID. Returns a single department based on ID.
    @GetMapping("/departments/{departmentId}")
    public DepartmentDTO getdepartment(@PathVariable(name="departmentId")Long departmentId) {
        Department department = departmentService.getDepartment(departmentId);
        DepartmentDTO departmentDTO = mapperComponent.getMapper().map(department, DepartmentDTO.class);
        return departmentDTO;
    }

    // Post for departments. Saves a new department to the database.
    @PostMapping("/departments")
    public ResponseEntity<String> saveDepartment(DepartmentDTO departmentDTO){
        Department department = mapperComponent.getMapper().map(departmentDTO, Department.class);
        departmentService.saveDepartment(department);
        return new ResponseEntity<String>("Department Saved Successfully", HttpStatus.OK);
    }

    // Delete for departments. Deletes a department based on ID
    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable(name="departmentId")Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<String>("Department Deleted Successfully", HttpStatus.OK);
    }

    // Put for departments. Updates a department if exists
    @PutMapping("/departments")
    public ResponseEntity<String> updateDepartment(@RequestBody DepartmentUpdateDTO departmentUpdateDTO){
        Department dep = departmentService.getDepartment(departmentUpdateDTO.getId());
        if(dep != null){
            Department department = mapperComponent.getMapper().map(departmentUpdateDTO, Department.class);
            departmentService.updateDepartment(department);
            return new ResponseEntity<String>("Department Updated", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Department not Found!", HttpStatus.NOT_FOUND);
    }

}