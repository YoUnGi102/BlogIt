package com.gres.tomas.businesstier.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Blog {

    @Id
    @SequenceGenerator(
            name="blog_id_sequence",
            sequenceName = "blog_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blog_id_sequence"
    )
    private Long id;

    private String name;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateTimeCreated;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    public Blog(){}

    public Blog(String name, String description, User author) {
        this.name = name;
        this.description = description;
        this.dateTimeCreated = LocalDateTime.now();
        this.author = author;
        this.rating = 0.0;
    }

    public User getAuthor() {
        return author;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }
    public Double getRating() {
        return rating;
    }

}
