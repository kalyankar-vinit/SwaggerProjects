package com.project1.joblisting.repository;

import com.project1.joblisting.model.JobPost;

import java.util.List;

public interface SearchRepository {

    List<JobPost> findByText(String text);
}
