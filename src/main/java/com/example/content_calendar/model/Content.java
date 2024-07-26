package com.example.content_calendar.model;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

// This is a entity class that represents a content in the system
public record Content(@Id
                      Integer id,
                      @NotBlank
                      String title,
                      String description,
                      Status status,
                      Type contentType,
                      LocalDateTime dateCreated,
                      LocalDateTime dateUpdated,
                      String url){

}
