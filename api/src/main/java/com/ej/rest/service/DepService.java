package com.ej.rest.service;

import com.ej.rest.model.Department;
import com.ej.rest.repo.DepJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepService {

    @Autowired
    DepJDBCRepository repository;


    public List<Department> findAll() {
        return repository.findAll();
    }

    public Optional<Department> findById(Long id) {
        return repository.findById(id);
    }

}
