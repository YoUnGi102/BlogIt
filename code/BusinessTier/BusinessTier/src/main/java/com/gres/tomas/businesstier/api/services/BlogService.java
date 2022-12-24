package com.gres.tomas.businesstier.api.services;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.gres.tomas.businesstier.api.exceptions.EntityNotFoundException;
import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import com.gres.tomas.businesstier.api.serviceInterfaces.IBlogService;
import com.gres.tomas.businesstier.domain.dto.CreateBlogDto;
import com.gres.tomas.businesstier.domain.helper.ValidationError;
import com.gres.tomas.businesstier.domain.model.Blog;
import com.gres.tomas.businesstier.domain.model.User;
import com.gres.tomas.businesstier.repositories.BlogRepository;
import com.gres.tomas.businesstier.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.util.List;
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

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        if(blog.isEmpty()){
            throw new EntityNotFoundException("Blog with this id was not found");
        }else{
            return blog.get();
        }
    }

    private static void ValidateCreateBlog(CreateBlogDto dto) throws InvalidAttributeException{

        ValidationError errors = new ValidationError();

        if(dto.getAccess() == null){
            throw new InvalidAttributeException("'Access' can not be null");
        }
        if(dto.getDescription() == null){
            throw new InvalidAttributeException("'Description' can not be null");
        }
        if(dto.getName() == null){
            throw new InvalidAttributeException("'Name' can not be null");
        }
        if (!dto.getAccess().equals("private") && !dto.getAccess().equals("public") && !dto.getAccess().equals("restricted")) {
            errors.addError("access", "The access can only be of type 'public', 'private' or 'restricted'");
        }
        if(dto.getDescription().length() < 50 || dto.getDescription().length() > 200){
            errors.addError("description", "The description has to be between 50 and 200 characters long");
        }
        if(dto.getName().length() < 5 || dto.getName().length() > 25){
            errors.addError("name", "The name of the blog post has to be between 5 and 25 characters long");
        }

        if(errors.hasErrors()){
            throw new InvalidAttributeException(errors.getJSONString());
        }

    }

}
