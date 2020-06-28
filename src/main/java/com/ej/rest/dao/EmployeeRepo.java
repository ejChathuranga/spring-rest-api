package com.ej.rest.dao;

import com.ej.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee, Integer> {
}
