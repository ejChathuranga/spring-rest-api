package com.ej.rest.api;

import com.ej.rest.model.Employee;
import com.ej.rest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v2/employee")
@RestController
public class EmpController {
    private final EmpService employeeRepository;

    @Autowired
    public EmpController(EmpService empService) {
        this.employeeRepository = empService;
    }

    @PostMapping
    public int add(@Valid @NonNull @RequestBody Employee employee) {
        return employeeRepository.insert(employee);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
        try {
            Optional<Employee> emp = employeeRepository.findById(id);
            return emp
                    .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @Valid @NonNull @RequestBody Employee employee) {
        ResponseEntity<Employee> entity = findById(id);
        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            employeeRepository.update(id, employee);
            employee.setId(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        ResponseEntity<?> entity = findById(id);
        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}

