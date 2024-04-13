package com.magret.repository;

import com.magret.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User , ObjectId> {

    List<User> findByName(String name);

    void deleteByName(String name);

    Optional<User> findByUserId(Long userId);

    void deleteByUserId(Long userId);


}
