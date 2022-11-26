package com.example.servletexample.runTimeRepository;

import com.example.servletexample.model.User;
import com.example.servletexample.model.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public enum Users {
    INSTANCE;
    public static final String connectionString = "jdbc:postgresql://localhost:5432/REWARDING_TW";
    private static final String connectionUsername = "postgres";
    private static final String connectionPassword = "admin";
    private List<UserDTO> users = new ArrayList<>();

    public void addUser(User user, String isExternal) {
        try{

            Connection con = DriverManager.getConnection(connectionString,connectionUsername,connectionPassword);
            String addUserQuery = "INSERT INTO users (username, points, isExternal) VALUES ('"+user.getEmail()+"', 0, " + isExternal + ") ";
            Statement statement = con.createStatement();
            statement.executeUpdate(addUserQuery);
        }
        catch(SQLException e){
            System.out.println("Error connecting to Database");
            e.printStackTrace();
        }

    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public UserDTO findUserByEmail(String email) {
        try{
            Connection con = DriverManager.getConnection(connectionString,connectionUsername,connectionPassword);
            String getUserQuery = "SELECT * FROM users WHERE username = '"+ email + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(getUserQuery);
            if(resultSet.next()){
                UserDTO userDTO = new UserDTO(resultSet.getString("username"), resultSet.getInt("points"), resultSet.getBoolean("isExternal"));
                return userDTO;
            }

        }
        catch (SQLException e){
            System.out.println("Error connecting to Database");
            e.printStackTrace();
        }
        return null;



    }
}
