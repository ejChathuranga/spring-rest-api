package com.ej.rest.api;

import com.ej.rest.entity.Employee;
import com.ej.rest.service.EmpService;
import com.ej.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmpService service;


    @Autowired
    public EmployeeController(EmployeeService employeeService, EmpService empService) {
        this.employeeService = employeeService;
        this.service = empService;
    }


    // RESTful API methods for Retrieval operations
    @GetMapping()
    public List<com.ej.rest.entity.Employee> list() {
        return service.listAll();
    }

    @GetMapping( path = "{id}")
    public ResponseEntity<com.ej.rest.entity.Employee> get(@PathVariable("id") Integer id) {
        try {
            com.ej.rest.entity.Employee product = service.get(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void add(@RequestBody com.ej.rest.entity.Employee product) {
        service.save(product);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable("id") Integer id) {
        try {
            Employee existProduct = service.get(id);
            service.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

//
//    @PostMapping
//    public void addEmployee(@Valid @NonNull @RequestBody Employee employee) {
//        employeeService.addEmployee(employee);
//    }
//
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping(path = "{id}")
//    public Employee getEmpById(@PathVariable("id") UUID id) {
//        return employeeService.getEmpById(id)
//                .orElse(null);
//    }
//
//    @DeleteMapping(path = "{id}")
//    public int deleteEmp(@PathVariable("id") UUID id) {
//        return employeeService.deleteEmpById(id);
//    }
//
//    @PutMapping(path = "{id}")
//    public int updateEmp(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Employee employee) {
//        return employeeService.updateEmpByID(id, employee);
//    }
}
