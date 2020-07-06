package com.ej.rest.api;


import com.ej.rest.model.Assignee;
import com.ej.rest.model.Employee;
import com.ej.rest.model.Response;
import com.ej.rest.service.AssigneeService;
import com.ej.rest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v2/assignee")
@RestController
@CrossOrigin(origins = "*")
public class AssigneeController {

    private final AssigneeService service;
    private final EmpService empService;

    @Autowired
    public AssigneeController(AssigneeService depService, EmpService empService) {
        this.service = depService;
        this.empService = empService;
    }


    @GetMapping
    public Optional<List<Employee>> findAll() {
        String name = "";
        return service.findSupervisors(name);
    }

    @PostMapping
    public Response<?> add(@Valid @NonNull @RequestBody Assignee assignee) {
//        System.out.println("assignee.getUserId():" + assignee.getUserId());
        return service.insert(assignee);
    }

    @GetMapping(path = "supervisors")
    public Optional<List<Employee>> findAllSupers() {
        System.out.println("in supervisorssssss...");
        String name = "";
        return service.findSupervisors(name);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Employee> getByUserId(@PathVariable("id") Long id) {
//        System.out.println("getByUserId:: " + id);
        try {
            Optional<Assignee> emp = service.findByUserId(id);
            if (emp.isPresent()){
                Optional<Employee> employee = empService.findById(emp.get().getSupervisorId());
                return employee
                        .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            }
            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
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
