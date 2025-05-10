package com.database.dao;

import com.database.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;

@Repository
public class UserDao {

    JdbcTemplate jdbcTemplate;

    //save the user
    public User saveUser(User user){
        String sql="insert into user(id,name,city,salary) values(?,?,?,?)";
        int rowsInserted= jdbcTemplate.update(
                sql,
                user.getId(),
                user.getName(),
                user.getCity(),
                user.getSalary()
        );
        System.out.println("Rows Inserted: "+rowsInserted);
        return user;
    }


    //update the user
    public User updateUser(User user){
        String sql="update user set name=?, city=?, salary=? where id=?";
        int rowsUpdated= jdbcTemplate.update(
                sql,
                user.getName(),
                user.getCity(),
                user.getSalary(),
                user.getId()
        );
        System.out.println("Rows Updated: "+rowsUpdated);
        return user;

    }

    //delete the user

    public int deleteUser(int id){
        String sql="delete from user where id=?";
        int rowsDeleted= jdbcTemplate.update(
                sql,
                id
        );
        System.out.println("Rows Deleted: "+rowsDeleted);
        return rowsDeleted;
    }

    //get the single user by id

    public User getUserById(int id){
        String sql="select * from user where id=?";
        User user= jdbcTemplate.queryForObject(
                sql,
                new UserRowMapper(),
                id
        );
        return user;
    }

    // get all the user
    public List<User> getAllUser(){
        String sql="select * from user";
      List<User> userList= jdbcTemplate.query(
              sql,
              new UserRowMapper()
      );
      return userList;
    }


    // search the user

    public List<User> searchUser(String titleKeyword){

        String sql="select * from user where title like ?";
        List<User> userList= jdbcTemplate.query(
                sql,
                new UserRowMapper(),
                "%"+titleKeyword+"%"
        );
        return userList;
    }


}
