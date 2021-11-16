package com.example.projectversion2.repository;

import com.example.projectversion2.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Integer> {
}
