package com.example.jobsearch.repository;

import com.example.jobsearch.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    
    // Custom query method to find jobs by title containing a specific keyword
    List<Job> findByTitleContaining(String keyword);
}
