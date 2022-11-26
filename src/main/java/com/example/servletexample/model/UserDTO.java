package com.example.servletexample.model;

public class UserDTO {
    private String email;


    private int points;
    private boolean isExternal;

    public UserDTO() {

    }

    public UserDTO(String email, int points, boolean isExternal) {
        this.email = email;
        this.points = points;
        this.isExternal = isExternal;
    }

    public String getEmail() {
        return this.email;
    }

    public int getPoints() {
        return points;
    }

    public boolean isExternal() {
        return isExternal;
    }


}
