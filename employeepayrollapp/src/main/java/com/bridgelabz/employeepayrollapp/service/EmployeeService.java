package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        log.info("Fetching employee with id: {}", id);
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        log.info("Adding Employee: {}", employeeDTO);
        Employee employee=new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        log.info("Updating employee with id: {}", id);
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(int id) {
        log.info("Deleting employee with id: {}", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
        employeeRepository.delete(employee);

    }
}