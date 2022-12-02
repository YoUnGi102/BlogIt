package com.gres.tomas.businesstier.api.controllers;

import com.gres.tomas.businesstier.api.serviceInterfaces.IBlogService;
import com.gres.tomas.businesstier.domain.dto.CreateBlogDto;
import com.gres.tomas.businesstier.domain.model.Blog;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
public class BlogController {

    private final IBlogService service;

    @Autowired
    public BlogController(IBlogService service){
        this.service = service;
    }

    @PostMapping
    public Blog postBlog(@RequestBody CreateBlogDto dto) {
        return service.postBlog(dto);
    }

//    @GetMapping
//    public List<Blog> getBlogs() {
//        throw new NotYetImplementedException();
//    }

//    @DeleteMapping(path = "{blogId}")
//    public void deleteAnimal(@PathVariable("blogId") int blogId) {
//        blogService.deleteAnimal(blogId);
//    }
//
//    @PutMapping(path = "{blogId}")
//    public void updateAnimal(@PathVariable("blogId") int blogId, @RequestParam(required = false) String species, @RequestParam(required = false) double weight, @RequestParam(required = false) ArrayList<AnimalPart> parts, @RequestParam(required = false) String origin, @RequestParam(required = false) LocalDate doa){
//        blogService.updateAnimal(blogId,species,weight,parts, origin,doa);
//    }

}
