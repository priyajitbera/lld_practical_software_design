package com.priyajit.entitiy.user;

import com.priyajit.entitiy.Entity;

import java.util.List;

public class User extends Entity {
    private String userName;
    private String firstName;
    private String lastName;
    private List<Role> roles;
}
