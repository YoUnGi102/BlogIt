package com.gres.tomas.businesstier.domain.dto;

public class CreateBlogDto {

    private final String name;
    private final String description;
    private final long authorId;
    private final String access;

    public CreateBlogDto(String name, String description, String access, long authorId) {
        this.name = name;
        this.access = access;
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
    public String getAccess() {
        return access;
    }
}
