package com.database.dao;

import com.database.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user=new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setCity(rs.getString("city"));
        user.setSalary(rs.getDouble("salary"));
        return user;
    }
}
