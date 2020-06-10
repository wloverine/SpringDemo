package com.jkl.test.service;

import com.jkl.test.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daryl on 2020/06/04 16:58
 */
public class UserService {
    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    private List<User> users = new ArrayList<>();

    {
        users.add(new User(1L, "bob@example.com", "password", "Bob"));
        users.add(new User(2L, "alice@example.com", "password", "Alice"));
        users.add(new User(3L, "tom@example.com", "password", "Tom"));
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getMail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed.");
    }

    public User getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public User register(String email, String password, String name) {
        users.forEach((user) -> {
            if (user.getMail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        });
        User user = new User(
                users.stream().mapToLong(u -> u.getId()).max().getAsLong(),
                email,
                password,
                name
        );
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }
}
