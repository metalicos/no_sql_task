package com.couchbase.learn.repository;

import com.couchbase.learn.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CouchbaseRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<List<User>> findBySport_SportName(String sportName);
}
