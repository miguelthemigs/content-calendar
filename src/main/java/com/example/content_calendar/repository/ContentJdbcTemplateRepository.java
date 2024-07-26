package com.example.content_calendar.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContentJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired // we injected jdbc template
    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
