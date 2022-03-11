package com.skf.labs.graphqlidor;


public class UserInfo {
    private int id;
    private String name;
    private String surname;
    private String date_of_birth;
    private String api_key;
    private int userId;
    
    public UserInfo(int id, String name, String surname, String date_of_birth, String api_key, int userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.api_key = api_key;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getApiKey() {
        return api_key;
    }

    public void setApiKey(String apiKey) {
        this.api_key = api_key;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    

}
