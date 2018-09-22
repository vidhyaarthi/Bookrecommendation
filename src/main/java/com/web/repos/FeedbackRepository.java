package com.web.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.UserFeedback;

@Repository
public interface FeedbackRepository extends CrudRepository<UserFeedback,Integer> {
    
    
}
