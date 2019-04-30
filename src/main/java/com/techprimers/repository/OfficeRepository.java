package com.techprimers.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.techprimers.model.Office;

@Component
public interface OfficeRepository extends JpaRepository<Office, String>{


	
}
