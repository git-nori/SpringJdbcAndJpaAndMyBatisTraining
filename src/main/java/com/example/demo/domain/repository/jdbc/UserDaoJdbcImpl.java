package com.example.demo.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int count() {
        String sql = "SELECT COUNT(*) FROM m_user";
        int count = jdbc.queryForObject(sql, Integer.class);

        return count;
    }

    @Override
    public int insertOne(User user) throws DataAccessException {
        String password = user.getPassword();

        String sql = "INSERT INTO m_user("
                + " user_id,"
                + " password,"
                + " user_name,"
                + " gender,"
                + " role)"
                + " VALUES(?, ?, ?, ?, ?)";
        int rowNumber = jdbc.update(sql
                , user.getUserId()
                , password
                , user.getUserName()
                , user.isGender()
                , user.getRole());

        return rowNumber;
    }

    @Override
    public User selectOne(String userId) throws DataAccessException {
        String sql = "SELECT * FROM m_user WHERE user_id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

        return jdbc.queryForObject(sql, rowMapper, userId);
    }

    @Override
    public List<User> selectMany() throws DataAccessException {
        String sql = "SELECT * FROM m_user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

        return jdbc.query(sql, rowMapper);
    }

    @Override
    public int updateOne(User user) throws DataAccessException {
        String password = user.getPassword();

        String sql = "UPDATE m_user SET"
                + " password = ?,"
                + " user_name = ?,"
                + " gender = ?"
                + " WHERE user_id = ?";
        int rowNumber = jdbc.update(sql
                , password
                , user.getUserName()
                , user.isGender()
                , user.getUserId());

        return rowNumber;
    }

    @Override
    public int deleteOne(String userId) throws DataAccessException {
        String sql = "DELETE FROM m_user WHERE user_id = ?";
        int rowNumber = jdbc.update(sql, userId);

        return rowNumber;
    }
}
