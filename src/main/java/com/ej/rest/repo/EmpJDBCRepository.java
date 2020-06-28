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
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmailId(rs.getString("email_id"));

            return employee;
        }
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", new EmpRowMapper());
    }

    public Optional<Employee> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from employee where id=?", new Object[]{
                        id
                },
                new BeanPropertyRowMapper<Employee>(Employee.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from employee where id=?", id);
    }

    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employee (id, first_name, last_name, email_id) " + "values(?, ?, ?, ?)",
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
    }

    public int update(Long id, Employee employee) {
        return jdbcTemplate.update("update employee " + " set first_name = ?, last_name = ?, email_id = ? " + " where id = ?",
                employee.getFirstName(), employee.getLastName(), employee.getEmailId(), id);
    }
}