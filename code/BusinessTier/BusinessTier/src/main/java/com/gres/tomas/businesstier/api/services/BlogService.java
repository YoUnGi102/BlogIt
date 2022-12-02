package com.gres.tomas.businesstier.api.services;

import com.gres.tomas.businesstier.api.serviceInterfaces.IBlogService;
import com.gres.tomas.businesstier.domain.dto.CreateBlogDto;
import com.gres.tomas.businesstier.domain.model.Blog;
import com.gres.tomas.businesstier.domain.model.User;
import com.gres.tomas.businesstier.repositories.BlogRepository;
import com.gres.tomas.businesstier.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(UserRepository userRepository, BlogRepository blogRepository) {
        this.userRepository = userRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog postBlog(CreateBlogDto dto) {
        Optional<User> user = userRepository.findById(dto.getAuthorId());
        if(user.isEmpty()){
            throw new EntityNotFoundException("The author with this Id ("+dto.getAuthorId()+") was not found ");
        }else{
            User author = user.get();
            Blog blog = new Blog(
                    dto.getName(),
                    dto.getDescription(),
                    author
            );
            return blogRepository.save(blog);
        }
    }

}
