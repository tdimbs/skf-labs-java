package com.skf.labs.graphqlidor;

import java.util.List;

import com.skf.labs.graphqlidor.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class GraphqlIdorModel {

@Autowired
private JdbcTemplate jdbcTemplate;

public List<User> getUsers(){
    String sql = "SELECT id,Username, Password, isAdmin FROM users";
    List<User> users = jdbcTemplate.query(sql, (resultSet, rowNum) -> new User(resultSet.getInt("id"),resultSet.getString("Username"), resultSet.getString("Password"),resultSet.getInt("isAdmin")==1?true:false));
    return users;
}
public List<UserInfo> getUserInfo(String apiKey){
    String sql = "SELECT id, name, surname, date_of_birth, api_key, userId FROM user_info WHERE api_key = ?";
    List<UserInfo> usersInfo = jdbcTemplate.query(sql, new Object[]{apiKey}, (resultSet, rowNum) -> new UserInfo(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("surname"),resultSet.getString("date_of_birth"),resultSet.getString("api_key"),resultSet.getInt("userId")));
    return usersInfo;
}

public List<UserInfo> getUserInfo(int userId){
    String sql = "SELECT id, name, surname, date_of_birth, api_key, userId FROM user_info WHERE userId = ?";
    List<UserInfo> usersInfo = jdbcTemplate.query(sql, new Object[]{userId}, (resultSet, rowNum) -> new UserInfo(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("surname"),resultSet.getString("date_of_birth"),resultSet.getString("api_key"),resultSet.getInt("userId")));
    return usersInfo;
}

public List<User> getUser(String username){
    String sql = "SELECT id, Username, Password, isAdmin FROM users WHERE Username=?";
    List<User> users = jdbcTemplate.query(sql,new Object[]{username} ,(resultSet, rowNum) -> new User(resultSet.getInt("id"),resultSet.getString("Username"), resultSet.getString("Password"),resultSet.getInt("isAdmin")==1?true:false));
    return users;
}
    
}


