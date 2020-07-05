package com.ej.rest.api;

import com.ej.rest.model.Employee;
import com.ej.rest.model.Response;
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
@CrossOrigin(origins = "*")
public class EmpController {
    private final EmpService service;

    @Autowired
    public EmpController(EmpService empService) {
        this.service = empService;
    }

    @PostMapping
    public Response add(@Valid @NonNull @RequestBody Employee employee) {
        return service.insert(employee);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
        try {
            Optional<Employee> emp = service.findById(id);
            return emp
                    .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "{id}")
    public Response update(@PathVariable("id") Long id, @Valid @NonNull @RequestBody Employee employee) {

        return service.update(id, employee);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        ResponseEntity<?> entity = findById(id);
        if (entity.getStatusCode().equals(HttpStatus.OK)) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public List<Employee> findAll() {
        return service.findAll();
    }

}

