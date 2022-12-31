package com.example.springpagination.repositoryStudent;

import com.example.springpagination.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryPatient extends JpaRepository<Patient,Long> {

    Page<Patient> findByNomContains(String kw, Pageable pageable);

}
