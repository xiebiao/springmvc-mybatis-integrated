package com.github.example.service;

import com.github.example.domain.User;

import java.util.List;


public interface UserService {
    public List<User> listAll(User user, int pageIndex, int pageSize);

    public void addUser(User user);
}
