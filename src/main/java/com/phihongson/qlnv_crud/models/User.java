package com.phihongson.qlnv_crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="User")
public class User implements Serializable {
    @Id
    @Column(name="username", length = 50)
    public String username;
    @Column(name="password", length = 50)
    private String password;
    @Column(name="fulname", length = 50)
    private String fullname;
    @Column(name="age")
    private Integer age;
    @Column(name="gender")
    private boolean gender;

    public User() {
    }

    public User(String username, String password, String fullname, Integer age, boolean gender) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
