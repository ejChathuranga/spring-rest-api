package com.ej.rest.api;

import com.ej.rest.model.Employee;
import com.ej.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "{id}")
    public Employee getEmpById(@PathVariable("id") UUID id) {
        return employeeService.getEmpById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deleteEmp(@PathVariable("id") UUID id) {
        return employeeService.deleteEmpById(id);
    }

    @PutMapping(path = "{id}")
    public int updateEmp(@PathVariable("id") UUID id, @RequestBody Employee employee) {
        return employeeService.updateEmpByID(id, employee);
    }
}
