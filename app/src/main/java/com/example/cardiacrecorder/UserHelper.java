package com.example.cardiacrecorder;

public class UserHelper {
    String firstname, Lastname, email, password;
    public UserHelper() {

    }

    public UserHelper(String firstname,String Lastname,String email,String password) {
        this.firstname = firstname;
        this.Lastname= Lastname;
        this.email= email;
        this.password = password;
    }




    public String getName() {
        return firstname;
    }

    public void setName(String name) {
        this.firstname = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setUsername(String username) {
        this.Lastname = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
