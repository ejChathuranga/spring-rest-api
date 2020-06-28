package com.ej.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.ej.rest.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EmpRowMapper implements RowMapper<Emp> {
        @Override
        public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
            Emp employee = new Emp();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmailId(rs.getString("email_id"));
            return employee;
        }
    }

    public List<Emp> findAll() {
        return jdbcTemplate.query("select * from employees", new EmpRowMapper());
    }

    public Optional<Emp> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from employees where id=?", new Object[]{
                        id
                },
                new BeanPropertyRowMapper<Emp>(Emp.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from employees where id=?", id);
    }

    public int insert(Emp employee) {
        return jdbcTemplate.update("insert into employees (id, first_name, last_name, email_id) " + "values(?, ?, ?, ?)",
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
    }

    public int update(Long id, Emp employee) {
        return jdbcTemplate.update("update employees " + " set first_name = ?, last_name = ?, email_id = ? " + " where id = ?",
                employee.getFirstName(), employee.getLastName(), employee.getEmailId(), id);
    }
}