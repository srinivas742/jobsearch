package com.example.jobsearch.service;

import com.example.jobsearch.entity.Job;
import com.example.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Method to add a new job
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    // Method to search for jobs by keyword in the title
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByTitleContaining(keyword);
    }

    // Method to apply for a job by ID
    public Job applyForJob(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        job.setApplied(true); // Mark the job as applied
        return jobRepository.save(job); // Save the updated job
    }

    // Method to retrieve all available jobs
    public List<Job> getAllAvailableJobs() {
        return jobRepository.findAll();
    }
}
