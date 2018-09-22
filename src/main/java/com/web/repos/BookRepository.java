package com.web.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
    
    
}
