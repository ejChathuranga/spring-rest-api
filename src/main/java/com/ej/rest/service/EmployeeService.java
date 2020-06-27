package com.ej.rest.service;

import com.ej.rest.dao.EmployeeDao;
import com.ej.rest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(@Qualifier("fakeDao") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int addEmployee(Employee employee) {
        return this.employeeDao.insertEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return this.employeeDao.getAllEmployees();
    }

    public Optional<Employee> getEmpById(UUID id) {
        return this.employeeDao.selectEmployeeById(id);
    }

    public int updateEmpByID(UUID id, Employee employee){
        return employeeDao.updateEmpById(id, employee);
    }

    public int deleteEmpById(UUID id){
        return employeeDao.deleteEmpById(id);
    }
}
