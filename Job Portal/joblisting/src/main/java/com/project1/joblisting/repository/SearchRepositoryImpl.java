package com.project1.joblisting.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.project1.joblisting.model.JobPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<JobPost> findByText(String text) {

        final List<JobPost> jobPosts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("db1");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                new Document("query", "engineer")
                .append("path", Arrays.asList("desc", "techstack", "profile")))),
                new Document("$sort",
                new Document("exp", 1L)),
                new Document("$limit", 3L)));

        result.forEach(doc -> jobPosts.add(converter.read(JobPost.class,doc)));

        return jobPosts;
    }
}
