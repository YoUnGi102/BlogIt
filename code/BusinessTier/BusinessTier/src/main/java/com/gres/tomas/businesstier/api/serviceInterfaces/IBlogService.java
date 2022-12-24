package com.gres.tomas.businesstier.api.serviceInterfaces;

import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import com.gres.tomas.businesstier.domain.dto.CreateBlogDto;
import com.gres.tomas.businesstier.domain.model.Blog;

import javax.management.BadAttributeValueExpException;
import java.util.List;

public interface IBlogService {

    Blog postBlog(CreateBlogDto dto) throws InvalidAttributeException;
    List<Blog> getAllBlogs();
    Blog getBlogById(long id);

}
