package com.ej.rest.api;


import com.ej.rest.model.Department;
import com.ej.rest.model.Employee;
import com.ej.rest.service.DepService;
import com.ej.rest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v2/department")
@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final DepService service;

    @Autowired
    public DepartmentController(DepService depService) {
        this.service = depService;
    }


    @GetMapping
    public List<Department> findAll() {
        return service.findAll();
    }


}
