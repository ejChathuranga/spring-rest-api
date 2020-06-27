package com.ej.rest.dao;

import com.ej.rest.model.Employee;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {

    int insertEmployee(UUID id, Employee employee);

    default int insertEmployee(Employee employee) {
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }

    List<Employee> getAllEmployees();

    Optional<Employee> selectEmployeeById(UUID id);

    int deleteEmpById(UUID id);

    int updateEmpById(UUID id, Employee employee);
}
