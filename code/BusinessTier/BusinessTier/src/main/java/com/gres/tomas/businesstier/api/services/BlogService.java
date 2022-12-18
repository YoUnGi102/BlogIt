package com.gres.tomas.businesstier.api.services;

import com.gres.tomas.businesstier.api.exceptions.EntityNotFoundException;
import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import com.gres.tomas.businesstier.api.serviceInterfaces.IBlogService;
import com.gres.tomas.businesstier.domain.dto.CreateBlogDto;
import com.gres.tomas.businesstier.domain.model.Blog;
import com.gres.tomas.businesstier.domain.model.User;
import com.gres.tomas.businesstier.repositories.BlogRepository;
import com.gres.tomas.businesstier.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
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
    public Blog postBlog(CreateBlogDto dto) throws InvalidAttributeException {
        Optional<User> user = userRepository.findById(dto.getAuthorId());
        if(user.isEmpty()){
            throw new EntityNotFoundException("The author with this Id ("+dto.getAuthorId()+") was not found ");
        }else{
            ValidateCreateBlog(dto);
            User author = user.get();
            Blog blog = new Blog(
                    dto.getName(),
                    dto.getDescription(),
                    author,
                    dto.getAccess()
            );
            return blogRepository.save(blog);
        }
    }

    private static void ValidateCreateBlog(CreateBlogDto dto) throws InvalidAttributeException{
        if(dto.getAccess() == null){
            throw new InvalidAttributeException("'Access' can not be null");
        }
        if(dto.getDescription() == null){
            throw new InvalidAttributeException("'Description' can not be null");
        }
        if(dto.getName() == null){
            throw new InvalidAttributeException("'Name' can not be null");
        }
        if (!dto.getAccess().equals("private") && !dto.getAccess().equals("public") && !dto.getAccess().equals("restricte")) {
            throw new InvalidAttributeException("The access can only be of type 'public', 'private' or 'restricted'");
        }
        if(dto.getDescription() != null && dto.getDescription().length() < 50){
            throw new InvalidAttributeException("The description has to be at least 50 characters long");
        }
        if(dto.getName() != null && dto.getName().length() < 5){
            throw new InvalidAttributeException("The name of the blog post has to be at least 5 characters long");
        }
    }

}
