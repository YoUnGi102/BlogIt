package com.gres.tomas.businesstier.api.serviceInterfaces;

import com.gres.tomas.businesstier.domain.dto.CreateBlogDto;
import com.gres.tomas.businesstier.domain.model.Blog;

import java.util.List;

public interface IBlogService {

    Blog postBlog(CreateBlogDto dto);

}