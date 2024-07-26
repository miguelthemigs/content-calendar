package com.example.content_calendar.controller;

import com.example.content_calendar.model.Content;
import com.example.content_calendar.model.Status;
import com.example.content_calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/content")
// the Controller interacts with the Service, which in turn interacts with the Repository
// Repository: Manages data access logic and provides a more object-oriented view of the persistence layer.
// Service: Implements business logic and coordinates interactions between repositories and other services.
// Controller: Handles HTTP requests and delegates tasks to the service layer.

public class ContentController  { // controller accepts requests and returns a response
    private final ContentRepository repository;
    @Autowired // we are doing dependency injection, because the constructor depends on repository (annotation optional)
    public ContentController(ContentRepository contentCollectionRepository) {
        this.repository = contentCollectionRepository;
    }

    // make a request and find all the pieces of content in the system
    @GetMapping("") // its in the url /content/all
    public List<Content> findAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){ // request body is the content that is being sent
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if (repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if (repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable String status){
        return repository.listByStatus(Status.valueOf(status));
    }
}
