package com.example.jobsearch.controller;

import com.example.jobsearch.entity.Job;
import com.example.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // Endpoint to add a new job
    @PostMapping
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job createdJob = jobService.addJob(job);
        return ResponseEntity.ok(createdJob);
    }

    // Endpoint to search for jobs by keyword
    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam String keyword) {
        List<Job> jobs = jobService.searchJobs(keyword);
        return ResponseEntity.ok(jobs);
    }

    // Endpoint to apply for a job by ID
    @PostMapping("/{id}/apply")
    public ResponseEntity<Job> applyForJob(@PathVariable Long id) {
        Job appliedJob = jobService.applyForJob(id);
        return ResponseEntity.ok(appliedJob);
    }

    // Endpoint to list all available jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllAvailableJobs() {
        List<Job> jobs = jobService.getAllAvailableJobs();
        return ResponseEntity.ok(jobs);
    }
}
