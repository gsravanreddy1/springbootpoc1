package com.poc.springbootpoc.service;

import com.poc.springbootpoc.entity.UserProfile;

import java.util.List;

public interface UserService {

    public UserProfile save(UserProfile userProfile);

    public UserProfile getUser(String userName);

    public List<UserProfile> getUserList();
}
