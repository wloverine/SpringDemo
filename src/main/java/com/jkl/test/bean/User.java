package com.jkl.test.bean;

/**
 * Created by Daryl on 2020/06/04 16:55
 */
public class User {
    private Long id;
    private String mail;
    private String password;
    private String name;

    public User() {
    }

    public User(Long id, String mail, String password, String name) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
