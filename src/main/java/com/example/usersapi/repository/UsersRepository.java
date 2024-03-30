package com.example.usersapi.repository;

import com.example.usersapi.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User,String> {

}
