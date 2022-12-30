package com.example.springpagination.repositoryStudent;

import com.example.springpagination.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface RepositoryStudent extends JpaRepository<Student,Long> {
}
