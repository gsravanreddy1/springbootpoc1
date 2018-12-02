package com.poc.springbootpoc.service;

import com.poc.springbootpoc.entity.UserProfile;
import com.poc.springbootpoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DataSource dataSource;

    @Override
    public UserProfile save(UserProfile userProfile) {
        userProfile = userRepository.save(userProfile);
        return userProfile;
    }

    @Override
    public UserProfile getUser(String userName) {
        UserProfile profile=null;
        try {
           Connection con = dataSource.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement("select * from user_profile where user_name=?");

            preparedStatement.setString(1,userName);

           ResultSet resultSet= preparedStatement.executeQuery();

           while(resultSet.next()){

               profile=new UserProfile();
               profile.setUserName(resultSet.getString("user_name"));
               profile.setPassword(resultSet.getString("password"));
               profile.setToken(resultSet.getString("token"));
          }


        } catch (SQLException e) {
            e.printStackTrace();
        }
return profile;
    }

    @Override
    public List<UserProfile> getUserList() {
       return (List<UserProfile>)userRepository.findAll();
    }


}
