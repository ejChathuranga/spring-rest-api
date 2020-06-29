package com.ej.rest.service;

import com.ej.rest.model.Response;
import com.ej.rest.repo.EmpJDBCRepository;
import com.ej.rest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

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

    public Optional<List<Employee>> findByEmail(Employee employee) {

        return repository.findByEmail(employee.getEmailId());
    }

    public int deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Response<?> insert(Employee employee) {
        Optional<List<Employee>> optionalEmployee = findByEmail(employee);
        if (optionalEmployee.get().size()==0 && repository.insert(employee) > 0) {
            return new Response<>(HttpStatus.OK.value());
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value(), "email id is already registered", null );
    }

    public int update(Long id, Employee employee) {
        return repository.update(id, employee);
    }
}
