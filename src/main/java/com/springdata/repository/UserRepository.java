package com.springdata.repository;

import com.springdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> getByEmail(String username);

    Optional<User> findByIdAndDeletedIsFalse(Long id);

    Optional<User> getByEmailAndDeletedFalse(String username);
}
