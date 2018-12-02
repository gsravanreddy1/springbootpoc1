package com.poc.springbootpoc.repository;

import com.poc.springbootpoc.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserProfile, String> {

    UserProfile findByUserName(String userName);

    UserProfile findByToken(String token);

}
