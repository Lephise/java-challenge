package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> retrieveDepartments();

    public Department getDepartment(Long departmentId);

    public void saveDepartment(Department department);

    public void deleteDepartment(Long departmentId);

    public void updateDepartment(Department department);
}