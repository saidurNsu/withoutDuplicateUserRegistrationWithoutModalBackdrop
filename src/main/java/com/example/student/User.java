package com.example.student;

import javax.persistence.*;

@Entity
//@Table(name="user_table")
@Table(name="user_details")
@NamedQuery(name="User.findAll", query="SELECT m FROM User m")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String department;

    public User() {
    }

    public User(Integer id, String username, String password, String role, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                '}';
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
