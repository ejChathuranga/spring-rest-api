package com.ej.rest.dao;

import com.ej.rest.model.Employee;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeEmployeeDataAccessService implements EmployeeDao {

    private List<Employee> DB = new ArrayList<>();

    @Override
    public int insertEmployee(UUID id, Employee employee) {
        DB.add(new Employee(id, employee.getName()));
        return 1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return DB;
    }

    @Override
    public Optional<Employee> selectEmployeeById(UUID id) {
        return DB.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteEmpById(UUID id) {
        Optional<Employee> employee = selectEmployeeById(id);

        if (!employee.isPresent()) {
            return 0;
        }
        DB.remove(employee.get());
        return 1;
    }

    @Override
    public int updateEmpById(UUID id, Employee employee) {
        return selectEmployeeById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Employee(id, employee.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
