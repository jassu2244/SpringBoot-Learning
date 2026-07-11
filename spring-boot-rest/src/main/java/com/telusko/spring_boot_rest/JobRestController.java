package com.telusko.spring_boot_rest;

import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000") // we are passing frontend url here in this annotation to remove
//cross-origin error and in frontend we just need to pass url of backend that is localhost:8080/jobPosts
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts") //also here whatever I pass will become that after "/jobPostss" thing
   // @ResponseBody //by default when we use Controller it searches for view page so we need this annotation to tell browser that
    //we are searching for data and not view page, If we use Rest Controller, we don't need response body annotation
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) { //this annotation tells what variable to search in query string
        return service.getJob(postId);
    }

    //here we are sending data from client
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) { // we use request body annotation to send data to server from client
        //this annotation is very important to send data
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);
        return "Deleted";
    }

}
