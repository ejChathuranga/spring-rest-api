package com.ej.rest.service;

import com.ej.rest.dao.EmployeeRepo;
import com.ej.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EmpService {

    @Autowired
    private EmployeeRepo repo;

    public List<Employee> listAll() {
        return repo.findAll();
    }

    public void save(Employee product) {
        repo.save(product);
    }

    public Employee get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void update(){

    }
}
