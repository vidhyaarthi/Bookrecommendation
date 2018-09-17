package com.web.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.User;

@Repository
public interface RegisterRepository extends CrudRepository<User,Integer> {
    
    
}
