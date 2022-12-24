package com.gres.tomas.businesstier.api.controllers;

import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import com.gres.tomas.businesstier.api.serviceInterfaces.IBlogService;
import com.gres.tomas.businesstier.domain.dto.CreateBlogDto;
import com.gres.tomas.businesstier.domain.model.Blog;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/blogs")
public class BlogController {

    private final IBlogService service;

    @Autowired
    public BlogController(IBlogService service){
        this.service = service;
    }

    @CrossOrigin
    @PostMapping
    public Blog postBlog(@RequestBody CreateBlogDto dto) throws InvalidAttributeException {
        return service.postBlog(dto);
    }

    @CrossOrigin
    @GetMapping(path = "{blogId}")
    public Blog getBlogById(@PathVariable("blogId") int blogId){
        return service.getBlogById(blogId);
    }

    @DeleteMapping(path = "{blogId}")
    public void deleteBlog(@PathVariable("blogId") int blogId) {
        throw new NotYetImplementedException();
    }

    @CrossOrigin
    @GetMapping
    public List<Blog> getBlogs() {
        return service.getAllBlogs();
    }


//
//    @PutMapping(path = "{blogId}")
//    public void updateAnimal(@PathVariable("blogId") int blogId, @RequestParam(required = false) String species, @RequestParam(required = false) double weight, @RequestParam(required = false) ArrayList<AnimalPart> parts, @RequestParam(required = false) String origin, @RequestParam(required = false) LocalDate doa){
//        blogService.updateAnimal(blogId,species,weight,parts, origin,doa);
//    }

}
