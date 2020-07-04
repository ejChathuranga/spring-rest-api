package com.ej.rest.repo;

import com.ej.rest.model.Department;
import com.ej.rest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class DepJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class DepRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();

            department.setId(rs.getLong("_id"));
            department.setName(rs.getString("_name"));
            department.setDesc(rs.getString("_desc"));

            return department;
        }
    }

    public List<Department> findAll() {
        return jdbcTemplate.query("select * from department", new DepRowMapper());
    }

    public Optional<Department> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from department where _id=?", new Object[]{
                        id
                },
                new DepRowMapper()));
    }
}