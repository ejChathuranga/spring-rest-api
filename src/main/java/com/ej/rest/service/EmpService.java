package com.ej.rest.service;

import com.ej.rest.repo.EmpJDBCRepository;
import com.ej.rest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmpService {

    @Autowired
    EmpJDBCRepository repository;


    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public int deleteById(Long id) {
        return repository.deleteById(id);
    }

    public int insert(Employee employee) {
        return repository.insert(employee);
    }

    public int update(Long id, Employee employee) {
        return repository.update(id, employee);
    }
}
