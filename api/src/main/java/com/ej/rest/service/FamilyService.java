package com.ej.rest.service;

import com.ej.rest.model.Family;
import com.ej.rest.repo.FamilyJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FamilyService {

    @Autowired
    FamilyJDBCRepository repository;


    public List<Family> findAll() {
        return repository.findAll();
    }

    public Optional<List<Family>> findById(Long id) {
        return repository.findMembersById(id);
    }

}
