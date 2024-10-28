package com.example.demo.service.Impl;

import com.example.demo.entity.Job;
import com.example.demo.exception.DataNotFound;
import com.example.demo.exception.InvalidData;
import com.example.demo.repository.JobRepository;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void saveJob(Job job) {
        if (job == null){
            throw new InvalidData("Invalid data");
        }
        Job job1 = jobRepository.getJobById(job.getId());
        if (job1 == null){
            jobRepository.save(job);
        }else{
            jobRepository.deleteById(job.getId());
            jobRepository.save(job);
        }
    }

    @Override
    public void deleteJob(Long id) {
        if(jobRepository.existsById(id)){
            jobRepository.deleteById(id);
        }else{
            throw new DataNotFound(id);
        }
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.getJobById(id);
    }
}
