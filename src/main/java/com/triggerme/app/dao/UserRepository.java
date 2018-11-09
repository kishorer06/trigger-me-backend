package com.triggerme.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.triggerme.app.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String Username);
}
