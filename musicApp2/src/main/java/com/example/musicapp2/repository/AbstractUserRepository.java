package com.example.musicapp2.repository;

import com.example.musicapp2.model.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractUserRepository extends JpaRepository<AbstractUser, Long> {
}
