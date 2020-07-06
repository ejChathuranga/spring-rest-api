package com.ej.rest.service;

import com.ej.rest.model.Assignee;
import com.ej.rest.model.Employee;
import com.ej.rest.model.Response;
import com.ej.rest.repo.AssigneeJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssigneeService {

    @Autowired
    AssigneeJDBCRepository repository;

    @Autowired
    EmpService empService;


    public List<Assignee> findAll() {
        return repository.findAll();
    }

    public Optional<List<Employee>> findSupervisors(String name){
        return empService.findAllSupers(name);
    }

    public Optional<Assignee> findByUserId(Long id) {
        return repository.findByUserId(id);
    }

    public Optional<Assignee> findBySupervisorId(Long id) {
        return repository.findBySupervisorId(id);
    }

    public Response<?> insert(Assignee assignee) {
        if (repository.add(assignee) >0){
            return new Response<>(HttpStatus.OK.value());
        }
        return new Response<>(HttpStatus.BAD_REQUEST.value());
    }
}
