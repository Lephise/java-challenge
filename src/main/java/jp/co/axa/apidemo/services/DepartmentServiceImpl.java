package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Department;
import jp.co.axa.apidemo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Returns list of all Departments present in the database
    @Override
    public List<Department> retrieveDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    // Returns Department by ID from database if present
    public Department getDepartment(Long departmentId) {
        Optional<Department> optDep = departmentRepository.findById(departmentId);
        return optDep.get();
    }

    // Persist a new Department to database
    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    // Delete a Department from database
    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    // Update an Employee in database
    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }
}