package com.ej.rest.api;

import com.ej.rest.model.Emp;
import com.ej.rest.service.EService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import sun.net.httpserver.HttpServerImpl;
import sun.rmi.runtime.Log;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v2/employee")
@RestController
public class EmpController {
    private final EService employeeRepository;

    @Autowired
    public EmpController(EService eService) {
        this.employeeRepository = eService;
    }

    @PostMapping
    public int add(@Valid @NonNull @RequestBody Emp emp) {
        return employeeRepository.insert(emp);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Emp> findById(@PathVariable("id") Long id) {
        try {
            Optional<Emp> emp = employeeRepository.findById(id);
            return emp
                    .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Emp> update(@PathVariable("id") Long id, @Valid @NonNull @RequestBody Emp emp) {
        ResponseEntity<Emp> entity = findById(id);
        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            employeeRepository.update(id, emp);
            emp.setId(id);
            return new ResponseEntity<>(emp, HttpStatus.OK);
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
    public List<Emp> findAll() {
        return employeeRepository.findAll();
    }

}

