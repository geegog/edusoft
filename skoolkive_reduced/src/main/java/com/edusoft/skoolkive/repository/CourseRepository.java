package com.edusoft.skoolkive.repository;

import com.edusoft.skoolkive.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
