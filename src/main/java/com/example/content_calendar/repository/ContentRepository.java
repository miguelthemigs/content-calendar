package com.example.content_calendar.repository;


import com.example.content_calendar.model.Content;
import com.example.content_calendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Spring sees that listcrudrepository is extended Spring Data automatically provides the implementation of the CRUD operations at runtime.
public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String keyword); // it will be turned in a method that exists in this implementation
    @Query("SELECT * FROM content WHERE status = :status")
    List<Content> listByStatus(@Param("status") Status status);

}

//    By extending ListCrudRepository, your the interface inherits several methods for working with Content persistence, such as:
//        List<Content> findAll()
//        Optional<Content> findById(Integer id)
//        Content save(Content entity)
//        void deleteById(Integer id)
