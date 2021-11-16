package com.example.projectversion2.repository;

import com.example.projectversion2.entity.UserEntity;
import org.h2.engine.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByCPF(String cpf);

    Optional<UserEntity> findByCPFAndPass(String cpf, String pass);
}
