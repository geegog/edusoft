package com.edusoft.skoolkive.repository;

import com.edusoft.skoolkive.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
