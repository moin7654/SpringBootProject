package com.database.dao;

import com.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveUser(User user){
        String sql="insert into user values(?,?,?,?)";
        int rowsUpdated= jdbcTemplate.update(sql,
                user.getId(),
                user.getName(),
                user.getCity(),
                user.getSalary());
        System.out.println("Rows Updated: "+rowsUpdated);
        return rowsUpdated;
    }

    public List<User> getAllUsers(){
        String sql="select * from user";
        List<User> users= jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        return users;

    }

    public User getUserById(int id){
        String sql="select * from user where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public int updateUser(User user){
        String sql="update user set name=?, city=?, salary=? where id=?";
        return jdbcTemplate.update(sql,user.getName(),user.getCity(),user.getSalary(),user.getId());
    }

    public int createUserTable(){
        String sql="create table if not exists user(id int primary key,name varchar(100) not null,city varchar(50), salary double)";
       return jdbcTemplate.update(sql);
    }

    public int deleteUser(int id){
        String sql="delete from user where id=?";
        return jdbcTemplate.update(sql,id);
    }


}
