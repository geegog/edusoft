package com.edusoft.skoolkive.repository;

import com.edusoft.skoolkive.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by Mahdad-PC on 11/4/2018.
 */

public interface StudentRepository extends JpaRepository<Student, Long> {
}
