package com.ej.rest.repo;

import com.ej.rest.model.Assignee;
import com.ej.rest.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AssigneeJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class AssigneeRowMapper implements RowMapper<Assignee> {
        @Override
        public Assignee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Assignee assignee = new Assignee();

            assignee.setId(rs.getLong("_id"));
            assignee.setUserId(rs.getLong("_user_id"));
            assignee.setSupervisorId(rs.getLong("_supervisor_id"));

            return assignee;
        }
    }

    public List<Assignee> findAll() {
        return jdbcTemplate.query("select * from assignee", new AssigneeRowMapper());
    }

    public Optional<Assignee> findByUserId(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from assignee where _user_id=?", new Object[]{
                        id
                },
                new AssigneeRowMapper()));
    }

    public Optional<Assignee> findBySupervisorId(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from assignee where _supervisor_id=?", new Object[]{
                        id
                },
                new AssigneeRowMapper()));
    }
}
