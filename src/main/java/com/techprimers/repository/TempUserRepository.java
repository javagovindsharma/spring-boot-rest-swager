package com.techprimers.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.techprimers.model.TempUser;

@Component
public interface TempUserRepository extends JpaRepository<TempUser, Serializable> {

}
