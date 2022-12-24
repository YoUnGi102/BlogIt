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

    private Integer posts;
    private Integer comments;
    private Integer likes;
    private Integer dislikes;

    private String access; // "private" / "public" / "restricted"
    private String name;
    private String description;

    private Double rating;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateTimeCreated;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    public Blog(){}

    public Blog(String name, String description, User author, String access) {
        this.name = name;
        this.description = description;
        this.dateTimeCreated = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
        this.author = author;
        this.rating = 0.0;
        this.posts = 0;
        this.likes = 0;
        this.dislikes = 0;
        this.comments = 0;
        this.access = access;
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
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
    public Double getRating() {
        return rating;
    }
    public Integer getPosts() {
        return posts;
    }
    public Integer getComments() {
        return comments;
    }
    public Integer getLikes() {
        return likes;
    }
    public Integer getDislikes() {
        return dislikes;
    }
    public String getAccess() {
        return access;
    }

}
