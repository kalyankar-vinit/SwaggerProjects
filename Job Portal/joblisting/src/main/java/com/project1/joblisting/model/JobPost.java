package com.project1.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection = "JobPost")
public class JobPost {
    //id,desc,exp,profile,techstack
    private String profile;
    private String desc;
    private int exp;
    private String techStack[];

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTechStack() {
        return techStack;
    }

    public void setTechStack(String[] techStack) {
        this.techStack = techStack;
    }

    public JobPost() {
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techStack=" + Arrays.toString(techStack) +
                '}';
    }
}
