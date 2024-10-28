package com.example.demo.service;

import com.example.demo.entity.Job;

import java.util.List;

public interface JobService {

    void saveJob(Job job);

    void deleteJob(Long id);

    List<Job> getAllJobs();

    Job getJobById(Long id);

}
