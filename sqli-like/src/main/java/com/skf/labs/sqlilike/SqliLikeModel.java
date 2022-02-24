package com.skf.labs.sqlilike;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.JdbcTemplate;


@Component
public class SqliLikeModel {

@Autowired
private JdbcTemplate jdbcTemplate;

public List<User> getUser(String username){
    String sql = "SELECT UserId, UserName, Password, email FROM users WHERE UserName LIKE '%"+username+"%' ORDER BY UserId";
    List<User> users = jdbcTemplate.query(sql, (resultSet, rowNum) -> new User(resultSet.getInt("UserId"),resultSet.getString("UserName"), resultSet.getString("Password"),resultSet.getString("email")));
    return users;
}
    
}
