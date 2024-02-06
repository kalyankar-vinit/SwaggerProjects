package com.project1.joblisting.repository;

import com.project1.joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<JobPost,String>
{

}
