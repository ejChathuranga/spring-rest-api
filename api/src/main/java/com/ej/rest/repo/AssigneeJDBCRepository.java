package com.ej.rest.repo;

import com.ej.rest.model.Assignee;
import com.ej.rest.model.Employee;
import com.ej.rest.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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

    public int add(Assignee assignee) {
        Optional<Assignee> optional = findByUserId(assignee.getUserId());
        return optional.map(value -> update(value.getId(), assignee)).orElseGet(() -> jdbcTemplate.update("insert into assignee " +
                        "(_id, _user_id, _supervisor_id ) " +
                        "values(?,?,?)",
                assignee.getId(), assignee.getUserId(), assignee.getSupervisorId()));
    }

    public int update(Long id, Assignee assignee) {
        return jdbcTemplate.update("update assignee " +
                        " set " +
                        "_user_id = ? ," +
                        "_supervisor_id = ? " +
                        "where " +
                        "_id = ?",
                assignee.getUserId(), assignee.getSupervisorId(), id);
    }

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
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from assignee where _user_id=?", new Object[]{
                            id
                    },
                    new AssigneeRowMapper()));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public Optional<Assignee> findBySupervisorId(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from assignee where _supervisor_id=?", new Object[]{
                        id
                },
                new AssigneeRowMapper()));
    }

    public int delete(Long id){
        return jdbcTemplate.update("delete from assignee where _id=?", id);
    }
}
