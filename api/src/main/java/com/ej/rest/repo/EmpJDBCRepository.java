package com.ej.rest.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.ej.rest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EmpRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("_id"));
            employee.setFirstName(rs.getString("_first_name"));
            employee.setLastName(rs.getString("_last_name"));
            employee.setEmailId(rs.getString("_email_id"));
            employee.setSalary(rs.getString("_salary"));
            employee.setAddress(rs.getString("_address"));
            employee.setDepartmentId(rs.getLong("_department_id"));
            employee.setRollId(rs.getLong("_roll_id"));

            return employee;
        }
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", new EmpRowMapper());
    }

    public Optional<Employee> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from employee where _id=?", new Object[]{
                        id
                },
                new EmpRowMapper()));
    }

    public Optional<List<Employee>> findByEmail(String email) {
        try {

            return Optional.of(jdbcTemplate.query("select * from employee where _email_id=?", new Object[]{
                            email
                    },
                    new BeanPropertyRowMapper<Employee>(Employee.class)));


        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


    public int deleteById(long id) {
        return jdbcTemplate.update("delete from employee where _id=?", id);
    }

    public int insert(Employee emp) {
        return jdbcTemplate.update("insert into employee " +
                        "(_id, _first_name, _last_name, _email_id, _salary, _address, _department_id, _roll_id) " +
                        "values(?, ?, ?, ?,?, ?, ?, ?)",
                emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId(),
                emp.getSalary(), emp.getAddress(), emp.getDepartmentId(), emp.getRollId());
    }

    public int update(Long id, Employee emp) {
        return jdbcTemplate.update(
                "update employee " + " set _first_name = ?, _last_name = ?, _email_id = ?, " +
                        " _salary = ?, _address = ?, _department_id = ?, _roll_id = ?" +
                        " where _id = ?",
                emp.getFirstName(), emp.getLastName(), emp.getEmailId(), emp.getSalary(), emp.getAddress(),
                emp.getDepartmentId(), emp.getRollId(),
                id);
    }
}