package com.gres.tomas.businesstier.domain.dto;

public class CreateBlogDto {

    private final String name;
    private final String description;
    private final long authorId;

    public CreateBlogDto(String name, String description, long authorId) {
        this.name = name;
        this.description = description;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public long getAuthorId() {
        return authorId;
    }
}
