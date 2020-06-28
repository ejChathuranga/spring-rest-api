package com.ej.rest.service;

import com.ej.rest.dao.EmpJDBCRepository;
import com.ej.rest.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EService {

    @Autowired
    EmpJDBCRepository repository;


    public List<Emp> findAll() {
        return repository.findAll();
    }

    public Optional<Emp> findById(Long id) {
        return repository.findById(id);
    }

    public int deleteById(Long id) {
        return repository.deleteById(id);
    }

    public int insert(Emp emp) {
        return repository.insert(emp);
    }

    public int update(Long id, Emp emp) {
        return repository.update(id, emp);
    }
}
