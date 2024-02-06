package com.project1.joblisting.controller;


import com.project1.joblisting.PostRepository;
import com.project1.joblisting.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping(value="/post")
    public JobPost addJobPost(@RequestBody JobPost post)
    {
        return repo.save(post);
    }
}
