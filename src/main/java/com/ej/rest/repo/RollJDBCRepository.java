package com.ej.rest.repo;

import com.ej.rest.model.EmpRoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class RollJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class RollRowMapper implements RowMapper<EmpRoll> {
        @Override
        public EmpRoll mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmpRoll roll = new EmpRoll();
            
            roll.setId(rs.getLong("_id"));
            roll.setName(rs.getString("_name"));
            roll.setDesc(rs.getString("_desc"));
            roll.setMinSalary(rs.getString("_min_salary"));
            roll.setMaxSalary(rs.getString("_max_salary"));

            return roll;
        }
    }

    public List<EmpRoll> findAll() {
        return jdbcTemplate.query("select * from emp_roll", new RollRowMapper());
    }

    public Optional<EmpRoll> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from emp_roll where _id=?", new Object[]{
                        id
                },
                new RollRowMapper()));
    }
}