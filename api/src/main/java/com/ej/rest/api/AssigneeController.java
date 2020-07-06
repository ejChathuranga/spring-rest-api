package com.ej.rest.api;


import com.ej.rest.model.Assignee;
import com.ej.rest.model.Department;
import com.ej.rest.model.Employee;
import com.ej.rest.service.AssigneeService;
import com.ej.rest.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v2/assignee")
@RestController
@CrossOrigin(origins = "*")
public class AssigneeController {

    private final AssigneeService service;

    @Autowired
    public AssigneeController(AssigneeService depService) {
        this.service = depService;
    }


    @GetMapping
    public List<Assignee> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Assignee> getByUserId(@PathVariable("id") Long id) {

        try {
            Optional<Assignee> emp = service.findByUserId(id);
            return emp
                    .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(path = "/supervisor/{id}")
    public ResponseEntity<Assignee> getBySupervisorId(@PathVariable("id") Long id) {

        try {
            Optional<Assignee> emp = service.findBySupervisorId(id);
            return emp
                    .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
