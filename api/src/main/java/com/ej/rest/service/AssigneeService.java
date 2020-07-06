package com.ej.rest.service;

import com.ej.rest.model.Assignee;
import com.ej.rest.repo.AssigneeJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssigneeService {

    @Autowired
    AssigneeJDBCRepository repository;


    public List<Assignee> findAll() {
        return repository.findAll();
    }

    public Optional<Assignee> findByUserId(Long id) {
        return repository.findByUserId(id);
    }

    public Optional<Assignee> findBySupervisorId(Long id) {
        return repository.findBySupervisorId(id);
    }

}
