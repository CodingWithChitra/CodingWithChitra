package com.codingwithchitra.codingwithchitra; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,
    String title,
    String description
) {
    // No-args constructor for JPA
    public Course() {
        this(null, null, null);
    }

    // "Setter" methods to return a new Course instance with updated fields
    public Course withId(Long id) {
        return new Course(id, this.title, this.description);
    }

    public Course withTitle(String title) {
        return new Course(this.id, title, this.description);
    }

    public Course withDescription(String description) {
        return new Course(this.id, this.title, description);
    }
}

