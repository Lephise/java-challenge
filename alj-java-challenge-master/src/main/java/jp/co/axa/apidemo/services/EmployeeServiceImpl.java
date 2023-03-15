package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    // Returns list of all Employees present in the database
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    // Returns Employee by Id from database if present
    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    // Persist a new Employee to database
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    // Delete an Employee from database
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    // Update an Employee in database
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}