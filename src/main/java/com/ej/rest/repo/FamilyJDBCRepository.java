package com.ej.rest.repo;

import com.ej.rest.model.EmpRoll;
import com.ej.rest.model.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class FamilyJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class FamilyRowMapper implements RowMapper<Family> {
        @Override
        public Family mapRow(ResultSet rs, int rowNum) throws SQLException {
            Family family = new Family();
            
            family.setId(rs.getLong("_id"));
            family.setEmpId(rs.getLong("_employee_id"));
            family.setFullName(rs.getString("_fullName"));
            family.setRelation(rs.getString("_relation"));
            family.setMobile(rs.getString("_mobile"));

            return family;
        }
    }

    public List<Family> findAll() {
        return jdbcTemplate.query("select * from family", new FamilyRowMapper());
    }

    public Optional<Family> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from family where _id=?", new Object[]{
                        id
                },
                new FamilyRowMapper()));
    }
}