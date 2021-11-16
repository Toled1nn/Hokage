package com.example.projectversion2.repository;

import com.example.projectversion2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepositoy extends JpaRepository<UserEntity, Integer> {
    boolean existsByCPF(String cpf);
}
