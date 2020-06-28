package com.ej.rest.api;

import com.ej.rest.model.Emp;
import com.ej.rest.service.EService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public int add() {
        return employeeRepository.insert(new Emp(10011L, "Ramesh", "Fadatare", "ramesh@gmail.com"));
    }

    @GetMapping
    public Optional<Emp> findById() {
        return employeeRepository.findById(10011L);
    }

    @PutMapping
    public int update() {
        return employeeRepository.update(new Emp(10011L, "ram", "Stark", "ramesh123@gmail.com"));
    }

//
//
//		logger.info("Inserting -> {}" , employeeRepository.insert(new Emp(10011L, "Ramesh", "Fadatare", "ramesh@gmail.com")));
//		logger.info("Inserting -> {}" , employeeRepository.insert(new Emp(10012L, "John", "Cena", "john@gmail.com")));
//		logger.info("Inserting -> {}"  , employeeRepository.insert(new Emp(10013L, "tony", "stark", "stark@gmail.com")));
//
//		logger.info("Employee id 10011 -> {}" , );
//
//		logger.info("Update 10003 -> {}" , employeeRepository.update(new Emp(10011L, "ram", "Stark", "ramesh123@gmail.com")));
//
//		employeeRepository.deleteById(10013L);
//
//		logger.info("All users -> {}" , employeeRepository.findAll());


}

