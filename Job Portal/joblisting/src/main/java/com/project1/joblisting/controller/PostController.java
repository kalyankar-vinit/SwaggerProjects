package com.project1.joblisting.controller;


import com.project1.joblisting.repository.PostRepository;
import com.project1.joblisting.model.JobPost;
import com.project1.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController
{
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository searchRepo;
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/posts")
    public List<JobPost> getAllJobPosts()
    {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> search(@PathVariable String text)
    {
        return searchRepo.findByText(text);
    }
    @PostMapping(value="/post")
    public JobPost addJobPost(@RequestBody JobPost post)
    {
        return repo.save(post);
    }
    
//    public JobPost deleteJobPost(@RequestBody JobPost post)
//    {
//
//    }
}
